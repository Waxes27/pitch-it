package com.pitchIT.PitchUserService.models.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatUserCrud{
    private String displayName;
    private String email;
    private String uid;
}
