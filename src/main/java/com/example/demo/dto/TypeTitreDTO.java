package com.example.demo.dto;


public class TypeTitreDTO {
    private Long id;
    private String codeTypeTitre;
    private String libelleTypeTitre;

    public TypeTitreDTO() {}

    public TypeTitreDTO(Long id, String codeTypeTitre, String libelleTypeTitre) {
        this.id = id;
        this.codeTypeTitre = codeTypeTitre;
        this.libelleTypeTitre = libelleTypeTitre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeTypeTitre() {
        return codeTypeTitre;
    }

    public void setCodeTypeTitre(String codeTypeTitre) {
        this.codeTypeTitre = codeTypeTitre;
    }

    public String getLibelleTypeTitre() {
        return libelleTypeTitre;
    }

    public void setLibelleTypeTitre(String libelleTypeTitre) {
        this.libelleTypeTitre = libelleTypeTitre;
    }
}
