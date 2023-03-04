package com.serveTechIT.ServeTechIt.user.registration;

import com.serveTechIT.ServeTechIt.user.AppUser;
import com.serveTechIT.ServeTechIt.user.UserRepository;
import com.serveTechIT.ServeTechIt.user.enums.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    public AppUser register(RegistrationRequest registrationRequest) {
        AppUser user = new AppUser(registrationRequest.name(), registrationRequest.username(),
                registrationRequest.email(), registrationRequest.password(),
                AppUserRole.USER);
        return userRepository.save(user);
    }
}
