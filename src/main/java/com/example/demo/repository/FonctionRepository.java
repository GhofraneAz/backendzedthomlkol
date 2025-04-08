package com.example.demo.repository;


import com.example.demo.entities.Fonction;
import com.example.demo.entities.Titre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long> , JpaSpecificationExecutor<Fonction> {
}

