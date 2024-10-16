package com.portoflio.back.security.controllers.impl;

import com.portoflio.back.data.entities.ExpiredToken;
import com.portoflio.back.security.controllers.ISecurityRestController;
import com.portoflio.back.security.dtos.Response.TokenResponseDto;
import com.portoflio.back.security.dtos.request.UserConnexionRequestDto;
import com.portoflio.back.services.IExpiredTokenService;
import com.portoflio.back.services.IJwtService;
import com.portoflio.back.services.impl.SecurityService;
import com.portoflio.back.web.dtos.response.RestResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SecurityRestController implements ISecurityRestController {
    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;
    private final IExpiredTokenService expiredTokenService;
    private final SecurityService securityService;

    @Override
    public ResponseEntity<?> login(UserConnexionRequestDto user) {

        Authentication authenticate =null ;

        Map<Object, Object> response=RestResponseDto.response(null, HttpStatus.NOT_FOUND);
        try {
             authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            if(authenticate.isAuthenticated()){

                //Generer le token
                String token= jwtService.createToken(user.getEmail());
                ExpiredToken expiredToken = expiredTokenService.findTokenInBlacklist(token);
                if(expiredToken != null){
                    response = RestResponseDto.response(null, HttpStatus.NO_CONTENT);
                }else{
                    TokenResponseDto tokenDto = TokenResponseDto.builder()
                            .token(token)
                            .username(user.getEmail())
                            .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                            .build();
                    response = RestResponseDto.response(tokenDto, HttpStatus.OK);
                }
            }

        }
        catch (Exception e){
            response = RestResponseDto.response(null, HttpStatus.NOT_FOUND);

        }


        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
