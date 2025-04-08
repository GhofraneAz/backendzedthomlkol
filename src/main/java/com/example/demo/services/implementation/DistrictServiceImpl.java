package com.example.demo.services.implementation;

import com.example.demo.entities.District;
import com.example.demo.entities.Titre;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.services.DistrictService;

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
public class DistrictServiceImpl implements DistrictService {
    
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public District getDistrictById(Long id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        return optionalDistrict.orElse(null);
    }

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
    @Override
    public List<District> SearchFilter(District district) {
        Specification<District> spec = new Specification<District>() {
            @Override
            public Predicate toPredicate(Root<District> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction(); // Condition vide

                // Vérification et ajout des conditions de filtre pour CodeDistrict
                if (district.getCodeDistrict() != null && !district.getCodeDistrict().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("CodeDistrict"), district.getCodeDistrict()));
                }

                // Vérification et ajout des conditions de filtre pour LibelleDistrict
                if (district.getLibelleDistrict() != null && !district.getLibelleDistrict().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("LibelleDistrict"), district.getLibelleDistrict()));
                }

                // Vérification et ajout des conditions de filtre pour LibelleDistrictAR
                if (district.getLibelleDistrictAR() != null && !district.getLibelleDistrictAR().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("LibelleDistrictAR"), district.getLibelleDistrictAR()));
                }

                // Vérification et ajout des conditions de filtre pour Reseaux
                if (district.getReseaux() != null && !district.getReseaux().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("Reseaux"), district.getReseaux()));
                }

                return predicate;
            }
        };

        // Exécution de la recherche avec la spécification
        return districtRepository.findAll(spec);
    }

    @Override
    public District updateDistrict(District district) {
        Optional<District> existingDistrictOptional = districtRepository.findById(district.getId());
        if (existingDistrictOptional.isPresent()) {
            District existingDistrict = existingDistrictOptional.get();
            existingDistrict.setCodeDistrict(district.getCodeDistrict());
            existingDistrict.setLibelleDistrict(district.getLibelleDistrict());
            existingDistrict.setLibelleDistrictAR(district.getLibelleDistrictAR());
            existingDistrict.setReseaux(district.getReseaux());
            return districtRepository.save(existingDistrict);
        }
        return null;
    }

    @Override
    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }
}

