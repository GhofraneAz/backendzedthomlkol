package com.example.demo.services;


import java.util.List;

import com.example.demo.entities.Titre;
import com.example.demo.entities.TypeTitre;

public interface TypeTitreService {
    TypeTitre createTypeTitre(TypeTitre typeTitre);
    TypeTitre getTypeTitreById(Long typeTitreId);
    List<TypeTitre> getAllTypeTitres();
    List<TypeTitre> SearchFilter(TypeTitre typeTitre);
    TypeTitre updateTypeTitre(TypeTitre typeTitre);
    void deleteTypeTitre(Long typeTitreId);
}

