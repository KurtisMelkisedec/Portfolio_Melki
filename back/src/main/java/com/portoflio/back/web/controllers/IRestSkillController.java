package com.portoflio.back.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/guest/skills")
public interface IRestSkillController {
    @GetMapping("")
    ResponseEntity<?> findAll();

    @GetMapping("/type/{type}")
    ResponseEntity<?> findSkillsByType(@PathVariable String type);

}
