package com.example.demo.services.implementation;


import com.example.demo.entities.Ligne;
import com.example.demo.repository.LigneRepository;
import com.example.demo.services.LigneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneServiceImpl implements LigneService {
    @Autowired
    private LigneRepository ligneRepository;

    @Override
    public Ligne createLigne(Ligne ligne) {
        return ligneRepository.save(ligne);
    }

    @Override
    public Ligne getLigneById(Long id) {
        Optional<Ligne> optionalLigne = ligneRepository.findById(id);
        return optionalLigne.orElseThrow(() -> new RuntimeException("Ligne non trouvée"));
    }

    @Override
    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }

    @Override
    public Ligne updateLigne(Ligne ligne) {
        Ligne existingLigne = ligneRepository.findById(ligne.getId())
                .orElseThrow(() -> new RuntimeException("Ligne non trouvée"));

        existingLigne.setCodeDistrict(ligne.getCodeDistrict());
        existingLigne.setLibelleLigne(ligne.getLibelleLigne());
        existingLigne.setOrigLigne(ligne.getOrigLigne());
        existingLigne.setDesigLigne(ligne.getDesigLigne());
        existingLigne.setReseaux(ligne.getReseaux());

        return ligneRepository.save(existingLigne);
    }

    @Override
    public void deleteLigne(Long idLigne) {
        ligneRepository.deleteById(idLigne);
    }
}

