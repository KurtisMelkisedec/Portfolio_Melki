package com.portoflio.back.services.impl;

import com.portoflio.back.data.entities.Project;
import com.portoflio.back.data.enums.Statut;
import com.portoflio.back.data.repositories.IProjectRepository;
import com.portoflio.back.services.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {
    private final IProjectRepository projectRepository;
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project findProjectByName(String name) {
        return projectRepository.findProjectByName(name);
    }

    @Override
    public Project findFavoriteProject() {
        return projectRepository.findProjectByIsFavoriteIsTrue();
    }

    @Override
    public void DeleteProject(Long id) {
         projectRepository.deleteById(id);
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAllByStatutNotOrderByIdDesc(Statut.Deleted,pageable);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAllByStatutOrderByIdDesc(Statut.Visible);
    }

    @Override
    public Page<Project> findAllByNameStartsWith(String name, Pageable pageable) {
        return projectRepository.findAllByNameStartingWith(name,pageable);
    }
}
