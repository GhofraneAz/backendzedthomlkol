package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Defaillant;

@Repository
public interface DefaillantRepository extends JpaRepository<Defaillant, Long> {
    
    // Tu peux ajouter des méthodes personnalisées ici si besoin
    // Par exemple :
    // List<Defaillant> findByCodeDistrict(String codeDistrict);


 

}
