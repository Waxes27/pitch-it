package com.pitchIT.PitchUserService.requests;

import com.pitchIT.PitchUserService.models.*;

public record PitchDetailsRequest(
        BusinessDetails businessDetails,
        CompanyDetails companyDetails,
        Documents documents,
        MarketDetails marketDetails,
        MemberDetails memberDetails
) {
}
