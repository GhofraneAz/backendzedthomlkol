package com.example.demo.controllers;

import com.example.demo.entities.District;
import com.example.demo.entities.Titre;
import com.example.demo.services.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@AllArgsConstructor
@RequestMapping("/api/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping("/createDistrict")
    // http://localhost:8080/api/districts
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        District savedDistrict = districtService.createDistrict(district);
        return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    // http://localhost:8080/api/districts/1
    public ResponseEntity<District> getDistrictById(@PathVariable("id") Long districtId) {
        District district = districtService.getDistrictById(districtId);
        return new ResponseEntity<>(district, HttpStatus.OK);
    }

    @GetMapping("/getAllDistricts")
    // http://localhost:8080/api/districts
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districtList = districtService.getAllDistricts();
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @PutMapping("/updateDistrict/{id}")
    // http://localhost:8080/api/districts/1
    public ResponseEntity<District> updateDistrict(@PathVariable("id") Long districtId, @RequestBody District district) {
        district.setId(districtId);
        District updatedDistrict = districtService.updateDistrict(district);
        return new ResponseEntity<>(updatedDistrict, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDistrict/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable Long id) {
        try {
            districtService.deleteDistrict(id);
            return ResponseEntity.ok().body(Collections.singletonMap("message", "District supprimé avec succès"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
    @PostMapping("/Search")
    // http://localhost:8080/api/districts
    public ResponseEntity<List<District>> Search(@RequestBody District district) {
        List<District> districtList = districtService.SearchFilter(district);
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

}
