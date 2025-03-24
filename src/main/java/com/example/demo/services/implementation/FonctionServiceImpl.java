package com.example.demo.services.implementation;


import com.example.demo.entities.Fonction;
import com.example.demo.repository.FonctionRepository;
import com.example.demo.services.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    private FonctionRepository fonctionRepository;

    @Override
    public Fonction createFonction(Fonction fonction) {
        return fonctionRepository.save(fonction);
    }

    @Override
    public Fonction getFonctionById(Long id) {
        Optional<Fonction> optionalFonction = fonctionRepository.findById(id);
        return optionalFonction.orElse(null);
    }

    @Override
    public List<Fonction> getAllFonctions() {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction updateFonction(Fonction fonction) {
        Fonction existingFonction = fonctionRepository.findById(fonction.getId()).orElseThrow(() -> new RuntimeException("Fonction not found"));
        existingFonction.setCodeFonction(fonction.getCodeFonction());
        existingFonction.setLibelleFonction(fonction.getLibelleFonction());
        return fonctionRepository.save(existingFonction);
    }

    @Override
    public void deleteFonction(Long id) {
        fonctionRepository.deleteById(id);
    }
}

