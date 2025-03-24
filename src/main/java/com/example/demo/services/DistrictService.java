package com.example.demo.services;


import java.util.List;
import com.example.demo.entities.District;

public interface DistrictService {
    District createDistrict(District district);
    District getDistrictById(Long id);
    List<District> getAllDistricts();
    District updateDistrict(District district);
    void deleteDistrict(Long id);
}

