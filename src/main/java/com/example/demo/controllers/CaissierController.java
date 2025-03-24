package com.example.demo.controllers;

import com.example.demo.entities.Caissier;
import com.example.demo.services.CaissierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@AllArgsConstructor
@RequestMapping("api/caissiers")
public class CaissierController {

    @Autowired
    private CaissierService caissierService;

    @CrossOrigin(origins = "http://localhost:4200")
    
    @PutMapping("/{id}")  // Correction ici
    public ResponseEntity<Caissier> modifierCaissier(@PathVariable Long id, @RequestBody Caissier caissier) {
        caissier.setIDCaissier(id);
        Caissier updatedCaissier = caissierService.updateCaissier(caissier);
        return new ResponseEntity<>(updatedCaissier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Caissier> createCaissier(@RequestBody Caissier caissier) {
        Caissier savedCaissier = caissierService.createCaissier(caissier);
        return new ResponseEntity<>(savedCaissier, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caissier> getCaissierById(@PathVariable("id") Long id) {
        Caissier caissier = caissierService.getCaissierById(id);
        return new ResponseEntity<>(caissier, HttpStatus.OK);
    }

    @GetMapping("/getAllCaissiers")
    public ResponseEntity<List<Caissier>> getAllCaissiers() {
        List<Caissier> caissierList = caissierService.getAllCaissiers();
        return new ResponseEntity<>(caissierList, HttpStatus.OK);
    }


    
    @DeleteMapping("/deleteCaissier/{id}")
    public ResponseEntity<?> deleteCaissier(@PathVariable Long id) {
        try {
        	caissierService.deleteCaissier(id);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "Fonction supprimée avec succès"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
