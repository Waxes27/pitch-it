package com.pitchIT.PitchUserService.requests;

public record InvestmentHistoryRequest(
        String company,
        String description,
        String fromYear,
        String toYear,
        String link
) {
}
