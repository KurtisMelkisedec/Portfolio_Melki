package com.portoflio.back.services.impl;

import com.portoflio.back.data.entities.Skill;
import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.data.enums.Statut;
import com.portoflio.back.data.repositories.ISkillRepository;
import com.portoflio.back.services.ISkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SkillService implements ISkillService {
    private final ISkillRepository skillRepository;
    @Override
    public List<Skill> findAllByTypeAndStatut(SkillType type, Statut statut) {
        return skillRepository.findAllByTypeAndStatut(type, statut);
    }

    @Override
    public Skill findByLibelle(String libelle) {
        return skillRepository.findSkillByLibelle(libelle);
    }
}
