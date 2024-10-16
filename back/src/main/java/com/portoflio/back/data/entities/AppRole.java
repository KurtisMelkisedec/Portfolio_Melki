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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
    @Enumerated(EnumType.STRING)
    private Statut statut=Statut.Visible;
    @ManyToMany(mappedBy = "roles")
    private List<AppUser>users=new ArrayList<>();

}
