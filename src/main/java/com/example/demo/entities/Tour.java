package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tours")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Corrigé pour suivre la convention Java (camelCase)

    @Column(name = "code_tour", nullable = false, unique = true) // Ajout de contraintes pour éviter les doublons
    private Long codeTour; 

    @Column(name = "code_district", nullable = false)
    private String codeDistrict;

    @Column(name = "libelle_tour", nullable = false)
    private String libelleTour;
}
