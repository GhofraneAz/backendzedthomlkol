package com.example.demo.dto;


public class GroupeDTO {
    private Long id;
    private String CodeDistrict;
    private String CodeGroupe;

    public GroupeDTO() {}

    public GroupeDTO(Long id, String CodeDistrict, String CodeGroupe) {
        this.id = id;
        this.CodeDistrict = CodeDistrict;
        this.CodeGroupe = CodeGroupe;
    }

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

    public String getCodeGroupe() {
        return CodeGroupe;
    }

    public void setCodeGroupe(String codeGroupe) {
        this.CodeGroupe = codeGroupe;
    }
}

