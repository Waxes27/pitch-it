package com.pitchIT.PitchUserService.requests;

public record ProfileRequest(
        String about,
        String pictureUrl
) {
}
