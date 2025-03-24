package com.example.demo.dto;


public class DistrictDTO {

    private Long id;
    private String CodeDistrict;
    private String LibelleDistrict;
    private String LibelleDistrictAR;
    private String Reseaux;

    // Constructeurs
    public DistrictDTO() {}

    public DistrictDTO(Long id, String codeDistrict, String libelleDistrict, String libelleDistrictAR, String reseaux) {
        this.id = id;
        this.CodeDistrict = codeDistrict;
        this.LibelleDistrict = libelleDistrict;
        this.LibelleDistrictAR = libelleDistrictAR;
        this.Reseaux = reseaux;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDistrict() {
        return CodeDistrict;
    }

    public void setCodeDistrict(String codeDistrict) {
        this.CodeDistrict = codeDistrict;
    }

    public String getLibelleDistrict() {
        return LibelleDistrict;
    }

    public void setLibelleDistrict(String libelleDistrict) {
        this.LibelleDistrict = libelleDistrict;
    }

    public String getLibelleDistrictAR() {
        return LibelleDistrictAR;
    }

    public void setLibelleDistrictAR(String libelleDistrictAR) {
        this.LibelleDistrictAR = libelleDistrictAR;
    }

    public String getReseaux() {
        return Reseaux;
    }

    public void setReseaux(String reseaux) {
        this.Reseaux = reseaux;
    }
}
