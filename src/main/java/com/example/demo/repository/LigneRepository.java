package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Fonction;
import com.example.demo.entities.Ligne;

@Repository
public interface LigneRepository extends JpaRepository<Ligne, Long> , JpaSpecificationExecutor<Ligne> {
}
