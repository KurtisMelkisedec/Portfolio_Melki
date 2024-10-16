package com.portoflio.back.data.repositories;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.data.enums.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISkillRepository extends JpaRepository<Skill, Long> {

    List<Skill>findAllByTypeAndStatut(SkillType type, Statut statut);

    Skill findSkillByLibelle(String libelle);
}
