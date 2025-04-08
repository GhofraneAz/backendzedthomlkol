package com.example.demo.repository;



import com.example.demo.entities.Groupe;
import com.example.demo.entities.Titre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> ,JpaSpecificationExecutor<Groupe> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}

