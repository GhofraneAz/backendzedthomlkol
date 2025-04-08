package com.example.demo.services;

import com.example.demo.entities.Caissier;
import com.example.demo.entities.Titre;

import java.util.List;

public interface CaissierService {
    Caissier createCaissier(Caissier caissier);
    Caissier getCaissierById(Long id);
    List<Caissier> getAllCaissiers();
    List<Caissier> SearchFilter(Caissier caissier);
    Caissier updateCaissier(Caissier caissier);
    void deleteCaissier(Long id);
}

