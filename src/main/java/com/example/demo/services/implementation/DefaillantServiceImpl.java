package com.example.demo.services.implementation;


import com.example.demo.entities.Agent;
import com.example.demo.entities.Caissier;
import com.example.demo.entities.Defaillant;
import com.example.demo.repository.DefaillantRepository;
import com.example.demo.services.DefaillantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaillantServiceImpl implements DefaillantService {

    @Autowired
    private DefaillantRepository defaillantRepository;

    // Récupérer tous les defaillants
    @Override
    public List<Defaillant> getAllDefaillants () {
        return defaillantRepository.findAll();
	
    }
    @Override
    public Defaillant getDefaillantById(Long id) {
        return defaillantRepository.findById(id).orElse(null); // ou une autre logique de récupération
 // Renvoie null si le caissier n'est pas trouvé
    }
    // Ajouter un defaillant

    @Override
    public Defaillant createDefaillant (Defaillant defaillant) {
        return defaillantRepository.save(defaillant);
    }
}
