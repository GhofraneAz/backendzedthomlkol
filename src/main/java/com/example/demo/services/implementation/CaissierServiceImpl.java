package com.example.demo.services.implementation;


import com.example.demo.entities.Caissier;
import com.example.demo.entities.Titre;
import com.example.demo.repository.CaissierRepository;
import com.example.demo.services.CaissierService;

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
public class CaissierServiceImpl implements CaissierService {

    @Autowired
    private CaissierRepository caissierRepository;

    @Override
    public Caissier createCaissier(Caissier caissier) {
        return caissierRepository.save(caissier);
    }

    @Override
    public Caissier getCaissierById(Long id) {
        return caissierRepository.findById(id).orElse(null); // ou une autre logique de récupération
 // Renvoie null si le caissier n'est pas trouvé
    }

    @Override
    public List<Caissier> getAllCaissiers() {
        return caissierRepository.findAll();
    }
    
    @Override
    public List<Caissier> SearchFilter(Caissier caissier) {
    	  Specification<Caissier> spec = new Specification<Caissier>() {
              @Override
              public Predicate toPredicate(Root<Caissier> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                  Predicate predicate = criteriaBuilder.conjunction();
                  
                  if (caissier.getCodeDistrict() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("CodeDistrict"), caissier.getCodeDistrict()));
                  }
                  if (caissier.getMLE() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("MLE"),  caissier.getMLE() ));
                  }
                  if (caissier.getCodeCaissier() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("CodeCaissier"), caissier.getCodeCaissier()));
                  }
                  if (caissier.getLibelleCaissier() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("(caissier.getLibelleCaissier"), caissier.getLibelleCaissier()));
                  }
                  
                  return predicate;
              }
          };
          
          return caissierRepository.findAll(spec);  
          }




    @Override
    public Caissier updateCaissier(Caissier caissier) {
        Caissier existingCaissier = caissierRepository.findById(caissier.getIDCaissier()).get();
        existingCaissier.setCodeDistrict(caissier.getCodeDistrict());
        existingCaissier.setMLE(caissier.getMLE());
        existingCaissier.setCodeCaissier(caissier.getCodeCaissier());
        existingCaissier.setLibelleCaissier(caissier.getLibelleCaissier());
        return caissierRepository.save(existingCaissier);
    }

    @Override
    public void deleteCaissier(Long idCaissier) {
        caissierRepository.deleteById(idCaissier);
    }
}

