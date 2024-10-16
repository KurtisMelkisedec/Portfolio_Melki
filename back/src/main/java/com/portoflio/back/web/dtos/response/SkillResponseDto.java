package com.portoflio.back.web.dtos.response;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.helpers.Helpers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SkillResponseDto {
    private Long id;
    private String libelle;
    private String image;



    public static SkillResponseDto toDto(Skill skill){
        return new SkillResponseDto(skill.getId(), skill.getLibelle(),
               Helpers.setImageFromBytes(skill.getImage())
                );
    }
}
