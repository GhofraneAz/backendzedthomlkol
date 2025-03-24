package com.example.demo.dto;



public class FonctionDTO {

    private Long id;
    private String codeFonction;
    private String libelleFonction;

    // Constructeurs
    public FonctionDTO() {}

    public FonctionDTO(Long id, String codeFonction, String libelleFonction) {
        this.id = id;
        this.codeFonction = codeFonction;
        this.libelleFonction = libelleFonction;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeFonction() {
        return codeFonction;
    }

    public void setCodeFonction(String codeFonction) {
        this.codeFonction = codeFonction;
    }

    public String getLibelleFonction() {
        return libelleFonction;
    }

    public void setLibelleFonction(String libelleFonction) {
        this.libelleFonction = libelleFonction;
    }
}

