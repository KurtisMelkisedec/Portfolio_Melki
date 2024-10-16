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
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    private byte[] image;
    @Enumerated(EnumType.STRING)
    private Statut statut = Statut.Visible;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole>roles=new ArrayList<>();

   public AppUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
