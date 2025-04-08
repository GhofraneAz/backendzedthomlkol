package com.example.demo.services;


import java.util.List;
import com.example.demo.entities.District;
import com.example.demo.entities.Titre;

public interface DistrictService {
    District createDistrict(District district);
    District getDistrictById(Long id);
    List<District> getAllDistricts();
    List<District> SearchFilter(District district);
    District updateDistrict(District district);
    void deleteDistrict(Long id);
}

