package com.example.demo.controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.TypeTitre;
import com.example.demo.services.TypeTitreService;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@AllArgsConstructor
@RequestMapping("api/typeTitres")
public class TypeTitreController {

    @Autowired
    private TypeTitreService typeTitreService;

    @PostMapping("/createTypeTitre")
    // http://localhost:8080/api/typeTitres
    public ResponseEntity<TypeTitre> createTypeTitre(@RequestBody TypeTitre typeTitre) {
        TypeTitre savedTypeTitre = typeTitreService.createTypeTitre(typeTitre);
        return new ResponseEntity<>(savedTypeTitre, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    // http://localhost:8080/api/typeTitres/1
    public ResponseEntity<TypeTitre> getTypeTitreById(@PathVariable("id") Long typeTitreId) {
        TypeTitre typeTitre = typeTitreService.getTypeTitreById(typeTitreId);
        if (typeTitre != null) {
            return new ResponseEntity<>(typeTitre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si l'entité n'est pas trouvée
        }
    }

    @GetMapping("/getAllTypeTitres")
    // http://localhost:8080/api/typeTitres
    public ResponseEntity<List<TypeTitre>> getAllTypeTitres() {
        List<TypeTitre> typeTitreList = typeTitreService.getAllTypeTitres();
        return new ResponseEntity<>(typeTitreList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/typeTitres/1
    public ResponseEntity<TypeTitre> updateTypeTitre(@PathVariable("id") Long typeTitreId, @RequestBody TypeTitre typeTitre) {
        typeTitre.setId(typeTitreId); // Assure-toi que l'ID est bien défini
        TypeTitre updatedTypeTitre = typeTitreService.updateTypeTitre(typeTitre);
        if (updatedTypeTitre != null) {
            return new ResponseEntity<>(updatedTypeTitre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourne 404 si l'entité à mettre à jour n'est pas trouvée
        }
    }

    @DeleteMapping("/deleteTypeTitre/{id}")
    public ResponseEntity<?> deleteTypeTitre(@PathVariable Long id) {
        try {
            typeTitreService.deleteTypeTitre(id);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "TypeTitre supprimé avec succès"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
    @PostMapping("/Search")
    // http://localhost:8080/api/typeTitres
    public ResponseEntity<List<TypeTitre>> Search(@RequestBody TypeTitre typeTitre) {
        List<TypeTitre> typeTitreList = typeTitreService.SearchFilter(typeTitre);
        return new ResponseEntity<>(typeTitreList, HttpStatus.OK);
    }
    }



