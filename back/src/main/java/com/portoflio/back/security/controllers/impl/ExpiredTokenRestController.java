package com.portoflio.back.security.controllers.impl;

import com.portoflio.back.data.entities.ExpiredToken;
import com.portoflio.back.security.controllers.IExpiredTokenRestController;
import com.portoflio.back.security.dtos.Response.TokenResponseDto;
import com.portoflio.back.services.IExpiredTokenService;
import com.portoflio.back.web.dtos.response.RestResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor


public class ExpiredTokenRestController implements IExpiredTokenRestController {
    private final IExpiredTokenService expiredTokenService;
    @Override
    public ResponseEntity<?> blackListToken(TokenResponseDto token) {
        ExpiredToken expiredToken = new ExpiredToken();

        expiredToken.setToken(token.getToken());
        expiredTokenService.save(expiredToken);

        return new ResponseEntity<>(RestResponseDto.response(expiredToken, HttpStatus.CREATED),HttpStatus.OK);
    }
}