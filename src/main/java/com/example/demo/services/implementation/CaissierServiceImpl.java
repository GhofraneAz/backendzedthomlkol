package com.example.demo.services.implementation;


import com.example.demo.entities.Caissier;
import com.example.demo.repository.CaissierRepository;
import com.example.demo.services.CaissierService;
import org.springframework.beans.factory.annotation.Autowired;
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

