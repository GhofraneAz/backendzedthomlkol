package com.example.demo.services;



import java.util.List;

import com.example.demo.entities.Ligne;
import com.example.demo.entities.Titre;

public interface LigneService {
    Ligne createLigne(Ligne ligne);
    Ligne getLigneById(Long id);
    List<Ligne> getAllLignes();
    List<Ligne> SearchFilter(Ligne ligne);
    Ligne updateLigne(Ligne ligne);
    void deleteLigne(Long id);
}

