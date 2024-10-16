package com.portoflio.back.web.dtos.response;

import com.portoflio.back.data.entities.Project;
import com.portoflio.back.helpers.Helpers;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProjectDetailsResponseDto {
    private Long id;
    private String name;
    private String story;
    private String video;
    private List<String> images;
    private String url;
    private String github;
    private List<SkillResponseDto>technologies;

    public static ProjectDetailsResponseDto toDto(Project project) {
        return new ProjectDetailsResponseDto(
                project.getId(),
                project.getName(),
                project.getStory(),
                (project.getVideo()==null || project.getUrl()!=null)?null: Helpers.setImageFromBytes(project.getVideo())  ,
                project.getUrl()!=null?null: project.getImages().stream().map(s-> Helpers.setImageFromBytes(s.getImage())).toList(),
                project.getUrl(),
                project.getGitHub(),
                project.getSkills().stream().map(skill -> SkillResponseDto.toDto(skill)).toList()
        );
    }
}
