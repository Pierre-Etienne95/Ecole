package com.example.EcoleProg.model;

import com.example.EcoleProg.view.VueMateriel;
import com.fasterxml.jackson.annotation.JsonView;
import com.example.EcoleProg.view.VueEtudiant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonView(VueEtudiant.class)
    protected Integer id;

    @JsonView({VueEtudiant.class, VueMateriel.class})
    protected String nom;

    @JsonView(VueEtudiant.class)
    protected String email;

    @JsonView(VueEtudiant.class)
    protected String cursus;

    @JsonView({VueEtudiant.class, VueMateriel.class})
    protected Integer annee;

    @JsonView(VueEtudiant.class)
    @OneToMany(mappedBy = "etudiant")
    private List<Pret> prets = new ArrayList<>();

    @JsonView(VueEtudiant.class)
    @OneToMany(mappedBy = "etudiant")
    private List<Probleme> problemes = new ArrayList<>();

}
