package com.pitchIT.PitchUserService.requests;

public record InvestorRegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
