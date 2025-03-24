package com.example.demo.repository;



import com.example.demo.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}

