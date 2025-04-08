package com.example.demo.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Groupe;
import com.example.demo.repository.GroupeRepository;
import com.example.demo.services.GroupeService;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupeServiceImpl implements GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    @Override
    public Groupe createGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public Groupe getGroupeById(Long id) {
        return groupeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Groupe non trouvé avec l'ID : " + id));
    }

    @Override
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Override
    public List<Groupe> SearchFilter(Groupe groupe) {
        Specification<Groupe> spec = (Root<Groupe> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (groupe.getCodeDistrict() != null && !groupe.getCodeDistrict().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, 
                        criteriaBuilder.equal(root.get("codeDistrict"), groupe.getCodeDistrict()));
            }
            if (groupe.getCodeGroupe() != null && !groupe.getCodeGroupe().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, 
                        criteriaBuilder.equal(root.get("codeGroupe"), groupe.getCodeGroupe()));
            }

            return predicate;
        };

        return groupeRepository.findAll(spec);
    }

    @Override
    public Groupe updateGroupe(Groupe groupe) {
        Groupe existingGroupe = groupeRepository.findById(groupe.getId())
                .orElseThrow(() -> new RuntimeException("Groupe non trouvé avec l'ID : " + groupe.getId()));

        existingGroupe.setCodeDistrict(groupe.getCodeDistrict());
        existingGroupe.setCodeGroupe(groupe.getCodeGroupe());
        return groupeRepository.save(existingGroupe);
    }

    @Override
    public void deleteGroupe(Long id) {
        if (!groupeRepository.existsById(id)) {
            throw new RuntimeException("Groupe non trouvé avec l'ID : " + id);
        }
        groupeRepository.deleteById(id);
    }
}
