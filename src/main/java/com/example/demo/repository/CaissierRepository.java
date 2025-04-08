package com.example.demo.repository;


import com.example.demo.entities.Caissier;
import com.example.demo.entities.Titre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CaissierRepository extends JpaRepository<Caissier, Long> ,  JpaSpecificationExecutor<Caissier> {
}

