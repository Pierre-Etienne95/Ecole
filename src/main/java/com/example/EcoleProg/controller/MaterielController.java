package com.example.EcoleProg.controller;

import com.example.EcoleProg.dao.MaterielDao;
import com.example.EcoleProg.model.Materiel;
import com.example.EcoleProg.view.VueEtudiant;
import com.example.EcoleProg.view.VueMateriel;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MaterielController {

    @Autowired
    private MaterielDao materielDao;

    @GetMapping("/materiel/{id}")
    @JsonView(VueMateriel.class)
    public ResponseEntity<Materiel> get(@PathVariable int id) {
        Optional<Materiel> optionalMateriel = materielDao.findById(id);

        if (optionalMateriel.isPresent()) {
            return new ResponseEntity<>(optionalMateriel.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/materiels")
    @JsonView(VueMateriel.class)
    public List<Materiel> getAll() {
        return materielDao.findAll();
    }

    @DeleteMapping("/materiel/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id) {
        if (materielDao.existsById(id)) {
            materielDao.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/materiel")
    public ResponseEntity<Materiel> add(@RequestBody Materiel materiel) {
        // L'ID ne doit pas être défini pour une création
        if (materiel.getId() == null || !materielDao.existsById(materiel.getId())) {
            Materiel savedMateriel = materielDao.save(materiel);
            return new ResponseEntity<>(savedMateriel, HttpStatus.CREATED);
        }

        // Si l'ID existe déjà, cela signifie que la requête est mal formée
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
