package com.pitchIT.PitchService.requests;

import com.pitchIT.PitchService.models.*;

public record PitchDetailsRequest(
        BusinessDetails businessDetails,
        CompanyDetails companyDetails,
        Documents documents,
        MarketDetails marketDetails,
        MemberDetails memberDetails
) {
}
