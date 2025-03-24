package com.example.demo.services;

import com.example.demo.entities.Caissier;

import java.util.List;

public interface CaissierService {
    Caissier createCaissier(Caissier caissier);
    Caissier getCaissierById(Long id);
    List<Caissier> getAllCaissiers();
    Caissier updateCaissier(Caissier caissier);
    void deleteCaissier(Long id);
}

