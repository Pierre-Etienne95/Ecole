package com.example.EcoleProg.dao;

import com.example.EcoleProg.model.Etudiant;
import com.example.EcoleProg.model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielDao extends JpaRepository<Materiel, Integer> {
}
