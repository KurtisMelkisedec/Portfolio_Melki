package com.portoflio.back.web.controllers.impl;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.data.enums.Statut;
import com.portoflio.back.data.repositories.ISkillRepository;
import com.portoflio.back.services.ISkillService;
import com.portoflio.back.web.controllers.IRestSkillController;
import com.portoflio.back.web.dtos.response.RestResponseDto;
import com.portoflio.back.web.dtos.response.SkillResponseDto;
import com.portoflio.back.web.dtos.response.SkillResponseHomeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SkillRestController implements IRestSkillController {
    private final ISkillRepository skillRepository;
    private final ISkillService skillService;
    @Override
    public ResponseEntity<?> findAll() {
        List<Skill> skills = skillRepository.findAll();
        Map<Object,Object>response = RestResponseDto.response(skills.stream().map(skill -> SkillResponseHomeDto.toDto(skill)).toList(), HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @Override
    public ResponseEntity<?> findSkillsByType(String type) {
        SkillType skillType = null;
        Map<Object,Object>response = RestResponseDto.response(null, HttpStatus.NOT_FOUND);
        if(type.compareTo("technologie")==0){
            skillType = SkillType.Technologie;
        }
        else if(type.compareTo("language")==0){
            skillType = SkillType.Language;
        }
        else if(type.compareTo("other")==0){
            skillType = SkillType.Other;
        }
        if(skillType!=null){
            List<Skill>skills = skillService.findAllByTypeAndStatut(skillType, Statut.Visible);
            response = RestResponseDto.response(skills.stream().map(SkillResponseDto::toDto).toList(), HttpStatus.OK);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
