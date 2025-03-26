package com.example.demo.dto;

public class AgentDTO {
    private Long id; // Identifiant
    private String codeDistrict;
    private String codeFonction;
    private String nom;
    private String prenom;
    private String codeEtatAgent;
    private String numTampon;
    private String bureauAffectation;

    public AgentDTO() {}

    public AgentDTO(Long id, String codeDistrict, String codeFonction, String nom, String prenom, 
                    String codeEtatAgent, String numTampon, String bureauAffectation) {
        this.id = id;
        this.codeDistrict = codeDistrict;
        this.codeFonction = codeFonction;
        this.nom = nom;
        this.prenom = prenom;
        this.codeEtatAgent = codeEtatAgent;
        this.numTampon = numTampon;
        this.bureauAffectation = bureauAffectation;
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

    public String getCodeFonction() {
        return codeFonction;
    }

    public void setCodeFonction(String codeFonction) {
        this.codeFonction = codeFonction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCodeEtatAgent() {
        return codeEtatAgent;
    }

    public void setCodeEtatAgent(String codeEtatAgent) {
        this.codeEtatAgent = codeEtatAgent;
    }

    public String getNumTampon() {
        return numTampon;
    }

    public void setNumTampon(String numTampon) {
        this.numTampon = numTampon;
    }

    public String getBureauAffectation() {
        return bureauAffectation;
    }

    public void setBureauAffectation(String bureauAffectation) {
        this.bureauAffectation = bureauAffectation;
    }
}
