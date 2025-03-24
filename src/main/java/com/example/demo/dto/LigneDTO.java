package com.example.demo.dto;



public class LigneDTO {
    private Long id;
    private String codeDistrict;
    private String libelleLigne;
    private String origLigne;
    private String desigLigne;
    private String reseaux;

    public LigneDTO() {}

    public LigneDTO(Long id, String codeDistrict, String libelleLigne, String origLigne, String desigLigne, String reseaux) {
        this.id = id;
        this.codeDistrict = codeDistrict;
        this.libelleLigne = libelleLigne;
        this.origLigne = origLigne;
        this.desigLigne = desigLigne;
        this.reseaux = reseaux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDistrict() {
        return codeDistrict;
    }

    public void setCodeDistrict(String codeDistrict) {
        this.codeDistrict = codeDistrict;
    }

    public String getLibelleLigne() {
        return libelleLigne;
    }

    public void setLibelleLigne(String libelleLigne) {
        this.libelleLigne = libelleLigne;
    }

    public String getOrigLigne() {
        return origLigne;
    }

    public void setOrigLigne(String origLigne) {
        this.origLigne = origLigne;
    }

    public String getDesigLigne() {
        return desigLigne;
    }

    public void setDesigLigne(String desigLigne) {
        this.desigLigne = desigLigne;
    }

    public String getReseaux() {
        return reseaux;
    }

    public void setReseaux(String reseaux) {
        this.reseaux = reseaux;
    }
}
