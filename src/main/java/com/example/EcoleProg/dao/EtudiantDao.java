package com.example.EcoleProg.dao;

import com.example.EcoleProg.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
}
