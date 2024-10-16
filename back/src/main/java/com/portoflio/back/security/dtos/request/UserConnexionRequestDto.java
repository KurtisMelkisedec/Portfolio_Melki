package com.portoflio.back.security.dtos.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserConnexionRequestDto {
    private String email;
    private String password;
}
