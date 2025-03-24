package com.example.demo.services.implementation;


import com.example.demo.entities.Tour;
import com.example.demo.repository.TourRepository;
import com.example.demo.services.TourService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public Tour createTour(Tour tour) {
        if (tour.getId() != null) {
            throw new IllegalArgumentException("ID must be null for new tours");
        }
        return tourRepository.save(tour);
    }


    @Override
    public Tour getTourById(Long codeTour) {
        Optional<Tour> optionalTour = tourRepository.findById(codeTour);
        return optionalTour.orElse(null);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour updateTour(Tour tour) {
        Tour existingTour = tourRepository.findById(tour.getCodeTour()).orElse(null);
        if (existingTour != null) {
            existingTour.setCodeDistrict(tour.getCodeDistrict());
            existingTour.setLibelleTour(tour.getLibelleTour());
            return tourRepository.save(existingTour);
        }
        return null;
    }

    @Override
    public void deleteTour(Long codeTour) {
        tourRepository.deleteById(codeTour);
    }
}

