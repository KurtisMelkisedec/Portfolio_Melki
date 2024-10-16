package com.portoflio.back.security.dtos.Response;

import com.portoflio.back.data.entities.AppUser;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
public class TokenResponseDto {
    private Long id;
    private String token;
    private String username;
    private List<String>roles = new ArrayList<>();



}
