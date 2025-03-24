package com.example.demo.services;



import com.example.demo.entities.Fonction;

import java.util.List;

public interface FonctionService {
    Fonction createFonction(Fonction fonction);
    Fonction getFonctionById(Long id);
    List<Fonction> getAllFonctions();
    Fonction updateFonction(Fonction fonction);
    void deleteFonction(Long id);
}

