package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "defaillants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Defaillant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeDistrict;
    private String nBcn;
    private String dateBcn;
    private String pnBcn;
    private String titre;
    private String serie;
    private String pnDef;
    private String dnDef;
    private int quantite;
    private String dateDefaillant;
    private String motif;

}
