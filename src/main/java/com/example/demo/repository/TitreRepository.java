package com.example.demo.repository;

import com.example.demo.entities.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitreRepository extends JpaRepository<Titre, Long> {
    // Ici, tu peux ajouter des méthodes personnalisées si nécessaire.
}


