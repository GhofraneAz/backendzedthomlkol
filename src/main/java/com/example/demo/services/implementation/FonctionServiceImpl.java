package com.example.demo.services.implementation;

import com.example.demo.entities.Fonction;
import com.example.demo.repository.FonctionRepository;
import com.example.demo.services.FonctionService;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    private FonctionRepository fonctionRepository;

    @Override
    public Fonction createFonction(Fonction fonction) {
        // Vérification d'un doublon, ou toute autre logique avant la création
        return fonctionRepository.save(fonction);
    }

    @Override
    public Fonction getFonctionById(Long id) {
        Optional<Fonction> optionalFonction = fonctionRepository.findById(id);
        return optionalFonction.orElseThrow(() -> new RuntimeException("Fonction not found with id: " + id));
    }

    @Override
    public List<Fonction> getAllFonctions() {
        return fonctionRepository.findAll();
    }

    @Override
    public List<Fonction> SearchFilter(Fonction fonction) {
        Specification<Fonction> spec = new Specification<Fonction>() {
            @Override
            public Predicate toPredicate(Root<Fonction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();  // Condition vide

                // Vérification et ajout des conditions de filtre pour CodeFonction
                if (fonction.getCodeFonction() != null && !fonction.getCodeFonction().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeFonction"), fonction.getCodeFonction()));
                }

                // Vérification et ajout des conditions de filtre pour LibelleFonction
                if (fonction.getLibelleFonction() != null && !fonction.getLibelleFonction().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("libelleFonction"), fonction.getLibelleFonction()));
                }

                return predicate;
            }
        };

        return fonctionRepository.findAll(spec);
    }

    @Override
    public Fonction updateFonction(Fonction fonction) {
        // Vérification de l'existence avant la mise à jour
        Fonction existingFonction = fonctionRepository.findById(fonction.getId())
                .orElseThrow(() -> new RuntimeException("Fonction not found with id: " + fonction.getId()));
        
        existingFonction.setCodeFonction(fonction.getCodeFonction());
        existingFonction.setLibelleFonction(fonction.getLibelleFonction());
        
        return fonctionRepository.save(existingFonction);
    }

    @Override
    public void deleteFonction(Long id) {
        if (!fonctionRepository.existsById(id)) {
            throw new RuntimeException("Fonction not found with id: " + id);
        }
        fonctionRepository.deleteById(id);
    }
}
