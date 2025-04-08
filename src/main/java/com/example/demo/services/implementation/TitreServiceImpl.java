package com.example.demo.services.implementation;


import com.example.demo.entities.Titre;
import com.example.demo.repository.TitreRepository;
import com.example.demo.services.TitreService;

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
public class TitreServiceImpl implements TitreService  {

    @Autowired
    private TitreRepository titreRepository;

    @Override
    public Titre createTitre(Titre titre) {
        return titreRepository.save(titre);
    }

    @Override
    public Titre getTitreById(Long id) {
        Optional<Titre> optionalTitre = titreRepository.findById(id);
        return optionalTitre.orElse(null);  // Retourne null si le titre n'existe pas
    }

    @Override
    public List<Titre> getAllTitres() {
        return titreRepository.findAll();
    }
    @Override
    public List<Titre> SearchFilter(Titre titre) {
    	  Specification<Titre> spec = new Specification<Titre>() {
              @Override
              public Predicate toPredicate(Root<Titre> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                  Predicate predicate = criteriaBuilder.conjunction();
                  
                  if (titre.getCodeTypeTitre() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("CodeTypeTitre"), titre.getCodeTypeTitre()));
                  }
                  if (titre.getLibelleTitre() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("LibelleTitre"),  titre.getLibelleTitre() ));
                  }
                  if (titre.getStkAlert() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("stkAlert"), titre.getStkAlert()));
                  }
                  if (titre.getCodeTarif() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("CodeTarif"), titre.getCodeTarif()));
                  }
                  if (titre.getNombrePoint() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("NombrePoint"), titre.getNombrePoint()));
                  }
                  if (titre.getUniteRVT() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("UniteRVT"), titre.getUniteRVT()));
                  }
                  if (titre.getABR() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("ABR"), titre.getABR()));
                  }
                  if (titre.getActif() != null) {
                      predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("actif"), titre.getActif()));
                  }
                  
                  return predicate;
              }
          };
          
          return titreRepository.findAll(spec);  
          }


    @Override
    public Titre updateTitre(Titre titre) {
        Titre existingTitre = titreRepository.findById(titre.getId()).orElse(null);
        if (existingTitre != null) {
            existingTitre.setCodeTypeTitre(titre.getCodeTypeTitre());
            existingTitre.setLibelleTitre(titre.getLibelleTitre());
            existingTitre.setStkAlert(titre.getStkAlert());
            existingTitre.setCodeTarif(titre.getCodeTarif());
            existingTitre.setNombrePoint(titre.getNombrePoint());
            existingTitre.setUniteRVT(titre.getUniteRVT());
            existingTitre.setABR(titre.getABR());
            existingTitre.setActif(titre.getActif());
            return titreRepository.save(existingTitre);
        }
        return null;  // Retourne null si le titre n'existe pas
    }

    @Override
    public void deleteTitre(Long id) {
        titreRepository.deleteById(id);
    }

	@Override
	public Optional<Titre> findById(Long titreId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}

