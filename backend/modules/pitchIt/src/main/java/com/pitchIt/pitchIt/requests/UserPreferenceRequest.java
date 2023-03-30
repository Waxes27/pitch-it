package com.pitchIt.pitchIt.requests;

import javax.persistence.Column;

public record UserPreferenceRequest(
        String industry,
        String location,
        String developmentStage,
        String customerGroup,
        String investmentStage,
        boolean seisPreference
        ) { }
