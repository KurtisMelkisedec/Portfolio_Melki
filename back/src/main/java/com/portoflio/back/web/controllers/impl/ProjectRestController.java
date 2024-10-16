package com.portoflio.back.web.controllers.impl;

import com.portoflio.back.data.entities.Image;
import com.portoflio.back.data.entities.Project;
import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.Statut;
import com.portoflio.back.helpers.Helpers;
import com.portoflio.back.services.IProjectService;
import com.portoflio.back.services.ISkillService;
import com.portoflio.back.web.controllers.IProjectRestController;
import com.portoflio.back.web.dtos.request.ProjectRequestDto;
import com.portoflio.back.web.dtos.response.*;
import jakarta.transaction.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProjectRestController implements IProjectRestController {
    private final ISkillService skillService;
    private final IProjectService projectService;
    @Override
    public ResponseEntity<?> save(ProjectRequestDto project) {
        Project newProject = new Project();
        newProject.setName(project.getTitle());
        newProject.setDescription(project.getDescription());
        newProject.setGitHub(project.getGithub());
        newProject.setUrl(project.getUrl());
        newProject.setMainImage(Helpers.getImageAsByte(project.getMainImage()));
        newProject.setStory(project.getStory());
       if(project.getVideo()!=null){
           newProject.setVideo(project.getVideo());

       }

        for (SkillResponseDto technoDto : project.getTechno()) {
            Skill skill = skillService.findByLibelle(technoDto.getLibelle());
            newProject.getSkills().add(skill);
            skill.getProjects().add(newProject);
        }

        for (String imageDto : project.getImages()) {
            Image image = new Image(Helpers.getImageAsByte(imageDto));
            newProject.getImages().add(image);
            image.setProject(newProject);
        }




        projectService.save(newProject);
        Map<Object,Object>response = RestResponseDto.response(null,HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAllAndPaginate(int page, int size,String title) {
        Page<Project> projects = projectService.findAll(PageRequest.of(page,size));
        if(title.compareTo("")!=0){
            projects = projectService.findAllByNameStartsWith(title,PageRequest.of(page,size));
        }

        Page<ProjectResponseListDto>projectsDto = projects.map(ProjectResponseListDto::toDto);
        Map<Object,Object>response = RestResponseDto.response(
                 projectsDto.getContent(),
                new int[projectsDto.getTotalPages()],
                projectsDto.getNumber(),
                projectsDto.getTotalElements(),
                projectsDto.getTotalPages()
                ,HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<Project> projects  = projectService.findAll();
        Map<Object,Object>response = RestResponseDto.response(projects.stream().map(project -> ProjectHomeResponseDto.toDto(project)).toList(),HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findProjectByName(String projectName) {
        Map<Object,Object>response = RestResponseDto.response(null,HttpStatus.NOT_FOUND);
        Project project = projectService.findProjectByName(projectName);
        if (project!=null) {
            response = RestResponseDto.response(ProjectDetailsResponseDto.toDto(project),HttpStatus.OK)  ;
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> setFavorite(Long id) {

        Project newFavoriteproject = projectService.findProjectById(id);
        Map<Object,Object>response = RestResponseDto.response(null,HttpStatus.NOT_FOUND);
        if(newFavoriteproject!=null){
            Project currentFavoriteProject = projectService.findFavoriteProject();
            newFavoriteproject.setIsFavorite(true);
            projectService.save(newFavoriteproject);
            currentFavoriteProject.setIsFavorite(false);
           projectService.save(currentFavoriteProject);
           response=RestResponseDto.response(null,HttpStatus.OK);

        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> setStatus(ProjectResponseListDto data) {
        Project project = projectService.findProjectById(data.getId());
        Map<Object,Object>response = RestResponseDto.response(null,HttpStatus.NOT_FOUND);
        if(project!=null){
            Statut status = Statut.Visible;
            if(data.getStatus()== Statut.Archive){
                status = Statut.Archive;
            }
             if(data.getStatus()== Statut.Deleted){
                status = Statut.Deleted;
                projectService.DeleteProject(project.getId());
            }
             else{

            project.setStatut(status);

            projectService.save(project);}
            response=RestResponseDto.response(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
