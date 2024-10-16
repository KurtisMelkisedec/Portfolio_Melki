package com.portoflio.back.security.controllers;

import com.portoflio.back.security.dtos.request.UserConnexionRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api")
public interface ISecurityRestController {

    @PostMapping("/login")
    ResponseEntity<?>login(@RequestBody UserConnexionRequestDto user);
}
