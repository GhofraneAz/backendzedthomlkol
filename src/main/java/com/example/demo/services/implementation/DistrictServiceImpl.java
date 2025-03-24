package com.example.demo.services.implementation;

import com.example.demo.entities.District;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
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

