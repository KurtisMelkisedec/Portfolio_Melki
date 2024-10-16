package com.portoflio.back.security.controllers;

import com.portoflio.back.security.dtos.Response.TokenResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api")
public interface IExpiredTokenRestController {

    @PostMapping("/admin/expiredToken")
    ResponseEntity<?> blackListToken(@RequestBody TokenResponseDto token);



}