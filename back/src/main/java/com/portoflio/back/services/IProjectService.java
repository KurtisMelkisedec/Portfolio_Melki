package com.portoflio.back.services;

import com.portoflio.back.data.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProjectService {
    Project save(Project project);
    Project findFavoriteProject();
    void DeleteProject(Long id);
    Project findProjectById(Long id);
    Project findProjectByName(String name);
    Page<Project> findAll(Pageable pageable);
    List<Project>findAll();
    Page<Project> findAllByNameStartsWith(String name,Pageable pageable);
}
