package com.example.demo.services;



import com.example.demo.entities.Titre;
import com.example.demo.entities.Tour;
import java.util.List;

public interface TourService {
    Tour createTour(Tour tour);
    Tour getTourById(Long id);
    List<Tour> getAllTours();
    List<Tour> SearchFilter(Tour tour);
    Tour updateTour(Tour tour);
    void deleteTour(Long id);
}

