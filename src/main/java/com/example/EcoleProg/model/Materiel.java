package com.example.EcoleProg.model;

import com.example.EcoleProg.view.VueEtudiant;
import com.example.EcoleProg.view.VueMateriel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VueMateriel.class)
    protected Integer id;

    @JsonView({VueEtudiant.class, VueMateriel.class})
    protected String nom;

    @JsonView(VueMateriel.class)
    protected String description;

    @JsonView(VueMateriel.class)
    protected String categorie;

    @JsonView(VueMateriel.class)
    @OneToMany(mappedBy = "materiel")
    private List<Pret> listePrets = new ArrayList<>();

    @OneToMany(mappedBy = "materiel")
    private List<Probleme> listeProblemes = new ArrayList<>();

}
