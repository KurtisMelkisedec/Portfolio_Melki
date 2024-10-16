package com.portoflio.back.web.controllers;

import com.portoflio.back.web.dtos.request.MailRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/guest/users")
public interface IUserRestController {

    @GetMapping("/admin")
    ResponseEntity<?>getAdmin();

    @PostMapping("send-mail")
    ResponseEntity<?>sendMail(@RequestBody MailRequestDto mail);

}
