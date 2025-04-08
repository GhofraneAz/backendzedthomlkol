package com.example.demo.services;



import java.util.List;

import com.example.demo.entities.Groupe;
import com.example.demo.entities.Ligne;

public interface GroupeService {
    Groupe createGroupe(Groupe groupe);
    Groupe getGroupeById(Long id);
    List<Groupe> getAllGroupes();
    List<Groupe> SearchFilter(Groupe groupe);
    Groupe updateGroupe(Groupe groupe);
    void deleteGroupe(Long id);
}
