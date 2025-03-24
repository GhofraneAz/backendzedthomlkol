package com.example.demo.services;


import com.example.demo.entities.Titre;

import java.util.List;
import java.util.Optional;

public interface TitreService {
    Titre createTitre(Titre titre);
    Titre getTitreById(Long id);
    List<Titre> getAllTitres();
    Titre updateTitre(Titre titre);
    void deleteTitre(Long id);
	Optional<Titre> findById(Long titreId);
}

