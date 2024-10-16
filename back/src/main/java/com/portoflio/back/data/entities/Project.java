package com.portoflio.back.data.entities;

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
@Getter
@Setter
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;
    @Column(length = 3000)

    private String story;
    @Column(nullable = true)
    private String url;
    @Column(nullable = true)
    private String gitHub;
    private Boolean isFavorite = false;
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    private byte[] video;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] mainImage;

    @Enumerated(EnumType.STRING)
    private Statut statut = Statut.Visible;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
    private List<Image>images=new ArrayList<>();
    @ManyToMany()
    private List<Skill> skills=new ArrayList<>();
}
