package com.portoflio.back.web.dtos.response;

import com.portoflio.back.data.entities.Project;
import com.portoflio.back.helpers.Helpers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProjectHomeResponseDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private List<SkillResponseHomeDto> skills;

    public static ProjectHomeResponseDto toDto(Project project) {
        return new ProjectHomeResponseDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                Helpers.setImageFromBytes(project.getMainImage()),
                project.getSkills().stream().map(skill -> SkillResponseHomeDto.toDto(skill)).toList()
        );
    }
}
