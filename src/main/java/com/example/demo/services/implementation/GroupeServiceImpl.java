package com.example.demo.services.implementation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Groupe;
import com.example.demo.repository.GroupeRepository;
import com.example.demo.services.GroupeService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeServiceImpl implements GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    @Override
    public Groupe createGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public Groupe getGroupeById(Long id) {
        Optional<Groupe> optionalGroupe = groupeRepository.findById(id);
        return optionalGroupe.orElse(null);  // Return null or throw exception if not found
    }

    @Override
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Override
    public Groupe updateGroupe(Groupe groupe) {
        Groupe existingGroupe = groupeRepository.findById(groupe.getId()).orElse(null);
        if (existingGroupe != null) {
            existingGroupe.setCodeDistrict(groupe.getCodeDistrict());
            existingGroupe.setCodeGroupe(groupe.getCodeGroupe());
            return groupeRepository.save(existingGroupe);
        }
        return null;  // Or throw exception if not found
    }

    @Override
    public void deleteGroupe(Long id) {
        groupeRepository.deleteById(id);
    }
}

