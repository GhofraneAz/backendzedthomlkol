package com.example.demo.services;



import com.example.demo.entities.Tour;
import java.util.List;

public interface TourService {
    Tour createTour(Tour tour);
    Tour getTourById(Long codeTour);
    List<Tour> getAllTours();
    Tour updateTour(Tour tour);
    void deleteTour(Long codeTour);
}

