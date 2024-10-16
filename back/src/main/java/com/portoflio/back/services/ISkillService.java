package com.portoflio.back.services;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.data.enums.Statut;

import java.util.List;

public interface ISkillService {
    List<Skill> findAllByTypeAndStatut(SkillType type, Statut statut);
    Skill findByLibelle(String libelle);

}
