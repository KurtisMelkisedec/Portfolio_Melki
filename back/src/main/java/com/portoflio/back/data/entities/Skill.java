package com.portoflio.back.data.entities;

import com.portoflio.back.data.enums.SkillType;
import com.portoflio.back.data.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
    @Enumerated(EnumType.STRING)
    private Statut statut=Statut.Visible;
    @Enumerated(EnumType.STRING)
    private SkillType type;
    @ManyToMany(mappedBy = "skills")
    private List<Project> projects = new ArrayList<>();
}
