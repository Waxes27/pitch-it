package com.serveTechIT.ServeTechIt.user.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//@Getter
//@AllArgsConstructor
//@ToString
public record RegistrationRequest(
        String name,
        String username,
        String email,
        String password) {
}
