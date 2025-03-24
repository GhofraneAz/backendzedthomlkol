package com.example.demo.dto;


public class TitreDTO {

    private Long id;
    private String CodeTypeTitre;
    private String LibelleTitre;
    private Integer stkAlert;
    private String CodeTarif;
    private Integer NombrePoint;
    private String UniteRVT;
    private String ABR;
    private Boolean actif;

    public TitreDTO() {}

    public TitreDTO(Long id, String codeTypeTitre, String libelleTitre, Integer stkAlert, String codeTarif, Integer nombrePoint, String uniteRVT, String abr, Boolean actif) {
        this.id = id;
        this.CodeTypeTitre = codeTypeTitre;
        this.LibelleTitre = libelleTitre;
        this.stkAlert = stkAlert;
        this.CodeTarif = codeTarif;
        this.NombrePoint = nombrePoint;
        this.UniteRVT = uniteRVT;
        this.ABR = abr;
        this.actif = actif;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeTypeTitre() {
        return CodeTypeTitre;
    }

    public void setCodeTypeTitre(String codeTypeTitre) {
        this.CodeTypeTitre = codeTypeTitre;
    }

    public String getLibelleTitre() {
        return LibelleTitre;
    }

    public void setLibelleTitre(String libelleTitre) {
        this.LibelleTitre = libelleTitre;
    }

    public Integer getstkAlert() {
        return stkAlert;
    }

    public void setstkAlert(Integer stkAlert) {
        this.stkAlert = stkAlert;
    }

    public String getCodeTarif() {
        return CodeTarif;
    }

    public void setCodeTarif(String codeTarif) {
        this.CodeTarif = codeTarif;
    }

    public Integer getNombrePoint() {
        return NombrePoint;
    }

    public void setNombrePoint(Integer nombrePoint) {
        this.NombrePoint = nombrePoint;
    }

    public String getUniteRVT() {
        return UniteRVT;
    }

    public void setUniteRVT(String uniteRVT) {
        this.UniteRVT = uniteRVT;
    }

    public String getABR() {
        return ABR;
    }

    public void setABR(String abr) {
        this.ABR = abr;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
}

