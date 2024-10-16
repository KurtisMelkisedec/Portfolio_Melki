package com.portoflio.back.data.fixtures;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.data.repositories.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
@Profile("prod")
@RequiredArgsConstructor
@Order(3)
public class SkillFixtures implements CommandLineRunner {
    private final ISkillRepository skillRepository;
    @Override
    public void run(String... args) throws Exception {
        List<String> skills = new ArrayList<>(Arrays.asList("Français,","Anglais","UML","Java","JavaScript","CSS","HTML","PHP","Flutter","Spring Boot","Angular","Laravel","Symfony"));
        for (int i = 0; i < 13; i++) {
            Skill skill = new Skill();
            skill.setLibelle(skills.get(i));
            if(i<2){
                skill.setType(SkillType.Language);
            }
            else if(i<3){
                    skill.setType(SkillType.Other);
            }
            else{
             skill.setType(SkillType.Technologie);
            }
            Path path = Paths.get(String.format("C:\\Users\\Dell\\Documents\\java\\back\\src\\main\\resources\\assets\\img%d.png", i));
            byte[]imagB = Files.readAllBytes(path);
            skill.setImage(imagB);
            skillRepository.save(skill);
        }
        
    }
}
