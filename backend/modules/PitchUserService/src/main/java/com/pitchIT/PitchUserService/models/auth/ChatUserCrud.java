package com.pitchIT.PitchUserService.models.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record ChatUserCrud(
        String documentId,
        String displayName,
        String email,
        String uid
) {
}
