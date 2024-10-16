package com.portoflio.back.web.dtos.response;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.helpers.Helpers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class SkillResponseHomeDto {
    private Long id;
    private String libelle;
    private String image;
    private SkillType type;

    public static SkillResponseHomeDto toDto(Skill skill) {
        return new SkillResponseHomeDto(
                skill.getId(),
                skill.getLibelle(),
                Helpers.setImageFromBytes(skill.getImage()),
                skill.getType()
        );
    }
}
