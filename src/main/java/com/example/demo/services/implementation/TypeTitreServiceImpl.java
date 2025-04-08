package com.example.demo.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Titre;
import com.example.demo.entities.TypeTitre;
import com.example.demo.repository.TypeTitreRepository;
import com.example.demo.services.TypeTitreService;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

@Service
public class TypeTitreServiceImpl implements TypeTitreService {

    @Autowired
    private TypeTitreRepository typeTitreRepository;

    @Override
    public TypeTitre createTypeTitre(TypeTitre typeTitre) {
        return typeTitreRepository.save(typeTitre);
    }

    @Override
    public TypeTitre getTypeTitreById(Long typeTitreId) {
        Optional<TypeTitre> optionalTypeTitre = typeTitreRepository.findById(typeTitreId);
        return optionalTypeTitre.orElse(null); // orElse(null) for safe null handling
    }

    @Override
    public List<TypeTitre> getAllTypeTitres() {
        return typeTitreRepository.findAll();
    }
    
    @Override
    public List<TypeTitre> SearchFilter(TypeTitre typeTitre) {
    	  Specification<TypeTitre> spec = new Specification<TypeTitre>() {
              @Override
              public Predicate toPredicate(Root<TypeTitre> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                  Predicate predicate = criteriaBuilder.conjunction();
                  
                  if (typeTitre.getCodeTypeTitre() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("CodeTypeTitre"), typeTitre.getCodeTypeTitre()));
                  }
                  if (typeTitre.getLibelleTypeTitre() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("LibelleTypeTitre"),  typeTitre.getLibelleTypeTitre() ));
                  }
                  return predicate;
              }
          };
          
          return typeTitreRepository.findAll(spec);  
          }




    @Override
    public TypeTitre updateTypeTitre(TypeTitre typeTitre) {
        Optional<TypeTitre> existingTypeTitre = typeTitreRepository.findById(typeTitre.getId());
        if (existingTypeTitre.isPresent()) {
            TypeTitre updatedTypeTitre = existingTypeTitre.get();
            updatedTypeTitre.setCodeTypeTitre(typeTitre.getCodeTypeTitre());
            updatedTypeTitre.setLibelleTypeTitre(typeTitre.getLibelleTypeTitre());
            return typeTitreRepository.save(updatedTypeTitre);
        }
        return null;
    }

    @Override
    public void deleteTypeTitre(Long typeTitreId) {
        typeTitreRepository.deleteById(typeTitreId);
    }
}

