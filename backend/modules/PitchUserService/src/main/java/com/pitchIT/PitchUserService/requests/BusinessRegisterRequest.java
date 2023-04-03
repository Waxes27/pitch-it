package com.pitchIT.PitchUserService.requests;

public record BusinessRegisterRequest(
        String businessName,
        String representativeFirstName,
        String representativeLastName,
        String businessRole,
        String email,
        String password
) {
}
