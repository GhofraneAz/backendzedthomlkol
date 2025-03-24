package com.example.demo.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "titres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Titre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CodeTypeTitre;
    private String LibelleTitre;
    private Integer stkAlert;
    private String CodeTarif;
    private Integer NombrePoint;
    private String UniteRVT;
    private String ABR;
    private Boolean actif;
}
