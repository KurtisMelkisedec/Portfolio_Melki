package com.portoflio.back.web.controllers.impl;

import com.portoflio.back.data.entities.AppUser;
import com.portoflio.back.services.ISecurityService;
import com.portoflio.back.web.controllers.IUserRestController;
import com.portoflio.back.web.dtos.request.MailRequestDto;
import com.portoflio.back.web.dtos.response.RestResponseDto;
import com.portoflio.back.web.dtos.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserRestController implements IUserRestController {
    private final ISecurityService securityService;
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private  String authMail;
    @Override
    public ResponseEntity<?> getAdmin() {
        AppUser user  = securityService.findAdmin();
        Map<Object, Object> response =  RestResponseDto.response(UserResponseDto.toDto(user), HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> sendMail(MailRequestDto mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(authMail);
        message.setSubject(String.format("Mail de %s via l'adresse %s sur ton portoflio",mail.getUsername(),mail.getMail()));
        message.setText(mail.getContent());
        mailSender.send(message);
        return new ResponseEntity<>(RestResponseDto.response(null,HttpStatus.OK),HttpStatus.OK);
    }
}
