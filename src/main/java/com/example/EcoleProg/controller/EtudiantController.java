package com.example.EcoleProg.controller;

import com.example.EcoleProg.dao.EtudiantDao;
import com.example.EcoleProg.model.Etudiant;
import com.example.EcoleProg.view.VueEtudiant;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EtudiantController {

    @Autowired
    private EtudiantDao etudiantDao;

    @GetMapping("/etudiant/{id}")
    @JsonView(VueEtudiant.class)
    public ResponseEntity<Etudiant> get(@PathVariable int id) {
        Optional<Etudiant> optionalEtudiant = etudiantDao.findById(id);

        if (optionalEtudiant.isPresent()) {
            return new ResponseEntity<>(optionalEtudiant.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/etudiants")
    @JsonView(VueEtudiant.class)
    public List<Etudiant> getAll() {
        return etudiantDao.findAll();
    }

    @DeleteMapping("/etudiant/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id) {
        if (etudiantDao.existsById(id)) {
            etudiantDao.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/etudiant")
    public ResponseEntity<Etudiant> add(@RequestBody Etudiant etudiant) {
        if (etudiant.getId() == null || !etudiantDao.existsById(etudiant.getId())) {
            Etudiant savedEtudiant = etudiantDao.save(etudiant);
            return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
        }

        // Si l'ID existe déjà, cela signifie que la requête est mal formée
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
