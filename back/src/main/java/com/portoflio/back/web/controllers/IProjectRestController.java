package com.portoflio.back.web.controllers;

import com.portoflio.back.web.dtos.request.ProjectRequestDto;
import com.portoflio.back.web.dtos.response.ProjectResponseListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/")
public interface IProjectRestController {

    @PostMapping("admin/projects")
    ResponseEntity<?>save(@RequestBody ProjectRequestDto project);
    @GetMapping("admin/projects")
    ResponseEntity<?> findAllAndPaginate(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "4") int size,
            @RequestParam(defaultValue = "")String title
    );
    @GetMapping("guest/projects")
    ResponseEntity<?>findAll();

    @GetMapping("guest/projects/{projectName}")
    ResponseEntity<?>findProjectByName(@PathVariable String projectName);

    @GetMapping("admin/projects/setFavorite/{id}")
    ResponseEntity<?>setFavorite(@PathVariable Long id);
    @PutMapping("admin/projects/setStatus")
    ResponseEntity<?>setStatus(@RequestBody ProjectResponseListDto project);

}
