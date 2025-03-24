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
@Table(name = "caissiers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Caissier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")  // Correspond au nom attendu en frontend
    private Long IDCaissier;

    private String CodeDistrict;
    private String MLE;
    private String CodeCaissier;
    private String LibelleCaissier;
}
