package com.portoflio.back.web.dtos.response;

import com.portoflio.back.data.entities.Project;
import com.portoflio.back.data.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProjectResponseListDto {
    private Long id;
    private String title;
    private String github;
    private String url;
    private Statut status;
    private Boolean isFavorite;

    public static ProjectResponseListDto toDto(Project project) {
        return new ProjectResponseListDto(
                project.getId(),
                project.getName(),
                project.getGitHub(),
                project.getUrl(),
                project.getStatut(),
                project.getIsFavorite()
        );
    }
}
