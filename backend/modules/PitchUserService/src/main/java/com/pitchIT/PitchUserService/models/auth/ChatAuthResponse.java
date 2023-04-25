package com.pitchIT.PitchUserService.models.auth;

public record ChatAuthResponse(
        String accessToken,
        String tokenType
) {
}
