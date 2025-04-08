package com.example.demo.services.implementation;

import com.example.demo.entities.Ligne;
import com.example.demo.repository.LigneRepository;
import com.example.demo.services.LigneService;
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
public class LigneServiceImpl implements LigneService {
    @Autowired
    private LigneRepository ligneRepository;

    @Override
    public Ligne createLigne(Ligne ligne) {
        return ligneRepository.save(ligne);
    }

    @Override
    public Ligne getLigneById(Long id) {
        return ligneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ligne non trouvée"));
    }

    @Override
    public List<Ligne> getAllLignes() {
        return ligneRepository.findAll();
    }

    @Override
    public List<Ligne> SearchFilter(Ligne ligne) {
        Specification<Ligne> spec = (Root<Ligne> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (ligne.getCodeDistrict() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeDistrict"), ligne.getCodeDistrict()));
            }
            if (ligne.getLibelleLigne() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("libelleLigne"), ligne.getLibelleLigne()));
            }
            if (ligne.getOrigLigne() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("origLigne"), ligne.getOrigLigne()));
            }
            if (ligne.getDesigLigne() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("desigLigne"), ligne.getDesigLigne()));
            }
            if (ligne.getReseaux() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("reseaux"), ligne.getReseaux()));
            }

            return predicate;
        };

        return ligneRepository.findAll(spec);
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
