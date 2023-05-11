package com.pitchIT.PitchUserService.services;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import com.pitchIT.PitchUserService.models.InvestmentHistory;
import com.pitchIT.PitchUserService.models.PitchBusinessUser;
import com.pitchIT.PitchUserService.models.PitchInvestorUser;
import com.pitchIT.PitchUserService.models.auth.ChatUserCrud;
import com.pitchIT.PitchUserService.repositories.BusinessUserRepository;
import com.pitchIT.PitchUserService.repositories.InvestmentHistoryRepository;
import com.pitchIT.PitchUserService.repositories.InvestorUserRepository;
import com.pitchIT.PitchUserService.requests.ProfileRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    BusinessUserRepository businessUserRepository;
    InvestorUserRepository investorUserRepository;
    InvestmentHistoryRepository investmentHistoryRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (businessUserRepository.findByEmail(email).isPresent()){
            return businessUserRepository.findByEmail(email).get();
        }
        else {return investorUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Business email not found"));}
    }


    public PitchBusinessUser registerBusinessUserByEmail(PitchBusinessUser pitchBusinessUser, String password) throws FirebaseAuthException {
        this.checkUser(pitchBusinessUser.getEmail());
        pitchBusinessUser.setPictureUrl("/assets/user-profile.png");

        PitchBusinessUser businessUser = businessUserRepository.save(pitchBusinessUser);
        ChatUserCrud crud = new ChatUserCrud(
                businessUser.getBusinessName(),
                businessUser.getEmail(),
                businessUser.getId().toString()

        );
        this.registerUserToFireStore(crud, password);
        return pitchBusinessUser;
    }

    public PitchInvestorUser registerInvestorUserByEmail(PitchInvestorUser investorUser, String password) throws FirebaseAuthException {
        this.checkUser(investorUser.getEmail());
        investorUser.setPictureUrl("/assets/user-profile.png");

        InvestmentHistory investmentHistory = new InvestmentHistory(
                investorUser
        );
        investorUser.setInvestmentHistory(investmentHistory);
        investmentHistory.setPitchInvestorUser(investorUser);
        investmentHistoryRepository.save(investmentHistory);
        PitchInvestorUser investorUserFromDb = investorUserRepository.save(investorUser);
        ChatUserCrud crud = new ChatUserCrud(
                investorUserFromDb.getEmail(),
                investorUserFromDb.getEmail(),
                investorUserFromDb.getId().toString()

        );
        this.registerUserToFireStore(crud,password);
        return investorUser;
    }

    private void checkUser(String email) {
        if (investorUserRepository.findByEmail(email).isPresent() || businessUserRepository.findByEmail(email).isPresent()){
            throw new IllegalStateException("User already Registered");
        }
    }

    public Optional getUser(String email){
        if (investorUserRepository.findByEmail(email).isPresent()){
            return investorUserRepository.findByEmail(email);
        }else if (businessUserRepository.findByEmail(email).isPresent()){
            return businessUserRepository.findByEmail(email);
        }else {
            throw new UsernameNotFoundException("Email not a business or investor");
        }
    }

    public PitchInvestorUser addToInvestmentHistoryByUser(String email, Map<String,String> investment) {
        PitchInvestorUser investorUser = investorUserRepository.findByEmail(email).get();
        System.out.println("INVESTMENT HISTORY:   "+investorUser);
        InvestmentHistory investmentHistory = investorUser.getInvestmentHistory();
        investmentHistory.addToInvestmentHistory(investment);
        investmentHistoryRepository.save(investmentHistory);
        System.out.println("InvestorUser:   "+investorUser.getInvestmentHistory());
        return investorUserRepository.save(investorUser);
    }

    public PitchInvestorUser updateAbout(String email,String about) {
        PitchInvestorUser investorUser = investorUserRepository.findByEmail(email).get();
        investorUser.setAbout(about);
        return investorUserRepository.save(investorUser);
    }

    public void updatePaid(String email) {
        if (businessUserRepository.findByEmail(email).isPresent()){
            System.out.println(businessUserRepository.findByEmail(email).isPresent());
            businessUserRepository.findByEmail(email).get().setPaid(true);
        }else if(investorUserRepository.findByEmail(email).isPresent()){
            System.out.println(investorUserRepository.findByEmail(email).isPresent());
            investorUserRepository.findByEmail(email).get().setPaid(true);
        }
        else throw new UsernameNotFoundException("User not found");
    }


    public Object editUserProfile(ProfileRequest profileRequest, String email) {
        if (investorUserRepository.findByEmail(email).isPresent()){
            PitchInvestorUser pitchInvestorUser = investorUserRepository.findByEmail(email).get();
            if (profileRequest.pictureUrl() != null){
                pitchInvestorUser.setPictureUrl(profileRequest.pictureUrl());
            }
            if (profileRequest.about() != null){
                pitchInvestorUser.setAbout(profileRequest.about());
            }
            investorUserRepository.save(pitchInvestorUser);
            return pitchInvestorUser;
        }else {
            PitchBusinessUser pitchBusinessUser = businessUserRepository.findByEmail(email).get();
            if (profileRequest.pictureUrl() != null){
                pitchBusinessUser.setPictureUrl(profileRequest.pictureUrl());
            }
            if (profileRequest.about() != null){
                pitchBusinessUser.setAbout(profileRequest.about());
            }
            businessUserRepository.save(pitchBusinessUser);
            return pitchBusinessUser;
        }

    }

    private void registerUserToFireStore(ChatUserCrud crud,String password) throws FirebaseAuthException {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUser(new UserRecord.CreateRequest()
                .setEmail(crud.getEmail())
                .setPassword(password)
                .setDisabled(false)
                .setDisplayName(crud.getEmail())
                .setEmailVerified(false)
                .setPhotoUrl("http://google.com")
                .setPhoneNumber("")

        );

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users")
                .document()
                .set(crud);
    }
}
