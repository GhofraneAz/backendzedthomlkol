package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Titre;
import com.example.demo.entities.TypeTitre;

@Repository
public interface TypeTitreRepository extends JpaRepository<TypeTitre, Long> , JpaSpecificationExecutor<TypeTitre>{
}


