package com.example.demo.controllers;


import com.example.demo.entities.Defaillant;
import com.example.demo.entities.District;
import com.example.demo.services.DefaillantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defaillants")
public class DefaillantController {

    @Autowired
    private DefaillantService defaillantService;

    // Endpoint pour récupérer tous les defaillants
    @GetMapping("/getAllDefaillants")
    public List<Defaillant> getAllDefaillants() {
        return defaillantService.getAllDefaillants();
    }
    @GetMapping("{id}")
 // http://localhost:8080/api/defaillants/1
 public ResponseEntity<Defaillant> getDefaillantById(@PathVariable("id") Long id) {
     Defaillant defaillant = defaillantService.getDefaillantById(id);
     
     if (defaillant != null) {
         return new ResponseEntity<>(defaillant, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }


    // Endpoint pour créer un nouveau defaillant
    @PostMapping("/createDefaillant")
    public ResponseEntity<Defaillant> createDefaillant(@RequestBody Defaillant defaillant) {
        Defaillant createdDefaillant = defaillantService.createDefaillant(defaillant);
        return new ResponseEntity<>(createdDefaillant, HttpStatus.CREATED);
    }
}

