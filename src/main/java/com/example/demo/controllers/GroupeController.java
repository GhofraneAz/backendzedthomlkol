package com.example.demo.controllers;


import com.example.demo.entities.Groupe;
import com.example.demo.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("api/groupes")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @PostMapping("/createGroupe")
    // http://localhost:8080/api/groupes
    public ResponseEntity<Groupe> createGroupe(@RequestBody Groupe groupe) {
        Groupe savedGroupe = groupeService.createGroupe(groupe);
        return new ResponseEntity<>(savedGroupe, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    // http://localhost:8080/api/groupes/1
    public ResponseEntity<Groupe> getGroupeById(@PathVariable("id") Long id) {
        Groupe groupe = groupeService.getGroupeById(id);
        return new ResponseEntity<>(groupe, HttpStatus.OK);
    }

    @GetMapping("/getAllGroupes")
    // http://localhost:8080/api/groupes
    public ResponseEntity<List<Groupe>> getAllGroupes() {
        List<Groupe> groupeList = groupeService.getAllGroupes();
        return new ResponseEntity<>(groupeList, HttpStatus.OK);
    }

    @PutMapping("/updateGroupe/{id}")
    // http://localhost:8080/api/groupes/1
    public ResponseEntity<Groupe> updateGroupe(@PathVariable("id") Long id, @RequestBody Groupe groupe) {
        groupe.setId(id);
        Groupe updatedGroupe = groupeService.updateGroupe(groupe);
        return new ResponseEntity<>(updatedGroupe, HttpStatus.OK);
    }

    @DeleteMapping("/deleteGroupe/{id}")
    public ResponseEntity<?> deleteGroupe(@PathVariable Long id) {
        try {
            groupeService.deleteGroupe(id);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "Groupe supprimé avec succès"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", e.getMessage()));
        }
    }


}
