package com.example.EcoleProg.model;

import com.example.EcoleProg.view.VueEtudiant;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Probleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @ManyToOne(optional = false)
    protected Etudiant etudiant;

    @ManyToOne(optional = false)
    protected Materiel materiel;

    @JsonView(VueEtudiant.class)
    protected String titre;

    @JsonView(VueEtudiant.class)
    protected String description;
}
