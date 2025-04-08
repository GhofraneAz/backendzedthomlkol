package com.example.demo.services;



import com.example.demo.entities.Defaillant;

import java.util.List;

public interface DefaillantService {

    // Ajouter un defaillant
    Defaillant createDefaillant(Defaillant defaillant);

    // Récupérer un defaillant par son ID
    Defaillant getDefaillantById(Long id);

    // Récupérer tous les defaillants
    List<Defaillant> getAllDefaillants();

    // Recherche et filtrage des defaillants


}

