package com.example.demo.services;



import com.example.demo.entities.Fonction;
import com.example.demo.entities.Titre;

import java.util.List;

public interface FonctionService {
    Fonction createFonction(Fonction fonction);
    Fonction getFonctionById(Long id);
    List<Fonction> getAllFonctions();
    List<Fonction> SearchFilter(Fonction fonction);
    Fonction updateFonction(Fonction fonction);
    void deleteFonction(Long id);
}

