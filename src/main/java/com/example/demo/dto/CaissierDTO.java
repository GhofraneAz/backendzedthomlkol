package com.example.demo.dto;

public class CaissierDTO {
    private Long id;
    private String codeDistrict;
    private String mle;
    private String codeCaissier;
    private String libelleCaissier;

    public CaissierDTO() {}

    public CaissierDTO(Long id, String codeDistrict, String mle, String codeCaissier, String libelleCaissier) {
        this.id = id;
        this.codeDistrict = codeDistrict;
        this.mle = mle;
        this.codeCaissier = codeCaissier;
        this.libelleCaissier = libelleCaissier;
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

    public String getMle() {
        return mle;
    }

    public void setMle(String mle) {
        this.mle = mle;
    }

    public String getCodeCaissier() {
        return codeCaissier;
    }

    public void setCodeCaissier(String codeCaissier) {
        this.codeCaissier = codeCaissier;
    }

    public String getLibelleCaissier() {
        return libelleCaissier;
    }

    public void setLibelleCaissier(String libelleCaissier) {
        this.libelleCaissier = libelleCaissier;
    }
}
