package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique (Matricule de l'agent)

    private String codeDistrict;  // Code du district de l'agent

    private String codeFonction;  // Code de la fonction de l'agent

    private String nom;  // Nom de l'agent

    private String prenom;  // Prénom de l'agent

    private String codeEtatAgent;  // Code de l'état de l'agent (ex: actif, inactif)

    private String numTampon;  // Numéro de tampon de l'agent

    private String bureauAffectation;  // Bureau d'affectation de l'agent
}
