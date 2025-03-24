package com.example.demo.repository;


import com.example.demo.entities.Tour;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    // Ici, nous pouvons ajouter des méthodes personnalisées si nécessaire
    // Par exemple, pour chercher une tournée par CodeTour :
    Optional<Tour> findByCodeTour(Long codeTour);
}

