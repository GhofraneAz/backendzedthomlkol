package com.example.demo.services;



import java.util.List;

import com.example.demo.entities.Ligne;

public interface LigneService {
    Ligne createLigne(Ligne ligne);
    Ligne getLigneById(Long id);
    List<Ligne> getAllLignes();
    Ligne updateLigne(Ligne ligne);
    void deleteLigne(Long id);
}

