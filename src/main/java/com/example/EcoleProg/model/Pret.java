package com.example.EcoleProg.model;

import com.example.EcoleProg.view.VueEtudiant;
import com.example.EcoleProg.view.VueMateriel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView(VueMateriel.class)
    @ManyToOne(optional = false)
    protected Etudiant etudiant;

    @JsonView(VueEtudiant.class)
    @ManyToOne(optional = false)
    protected Materiel materiel;

    @JsonView({VueEtudiant.class, VueMateriel.class})
    protected Date debut;

    @JsonView({VueEtudiant.class, VueMateriel.class})
    protected Date fin;
}
