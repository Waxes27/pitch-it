package com.serveTechIT.ServeTechIt.user.registration;

import com.serveTechIT.ServeTechIt.user.AppUser;
import com.serveTechIT.ServeTechIt.user.AppUserService;
import com.serveTechIT.ServeTechIt.user.UserRepository;
import com.serveTechIT.ServeTechIt.user.enums.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AppUserService appUserService;

    public AppUser register(RegistrationRequest registrationRequest) {
        AppUser user = new AppUser(registrationRequest.name(), registrationRequest.username(),
                registrationRequest.email(), registrationRequest.password(),
                AppUserRole.USER);


        System.out.println(appUserService.signUpUser(user));

        String encoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);

        return userRepository.save(user);
    }
}
