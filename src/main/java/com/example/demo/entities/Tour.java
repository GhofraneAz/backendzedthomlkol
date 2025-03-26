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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Identifiant unique pour la table

    private Long codeTour;  // Le code du tour, unique

    private String codeDistrict;  // Code du district lié au tour

    private String libelleTour;  // Libellé du tour
}
