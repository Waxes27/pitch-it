package com.waxes27.PitchIt.Models;

import com.waxes27.PitchIt.Enums.MembershipPlanType;
import com.waxes27.PitchIt.Enums.UserType;
import org.springframework.security.core.userdetails.UserDetails;


public interface IUser extends UserDetails {
    String name = null;
    UserType userType = null;
    MembershipPlanType membershipPlanType = null;
}
