package com.example.demo.repository;

import com.example.demo.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    // Rechercher les agents par code district
    List<Agent> findByCodeDistrict(String codeDistrict);

    // Rechercher les agents par code fonction
    List<Agent> findByCodeFonction(String codeFonction);

    // Rechercher les agents par état
    List<Agent> findByCodeEtatAgent(String codeEtatAgent);
}
