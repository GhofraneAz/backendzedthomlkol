package com.example.demo.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "lignes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ligne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeDistrict;
    private String libelleLigne;
    private String origLigne;
    private String desigLigne;
    private String reseaux;
}
