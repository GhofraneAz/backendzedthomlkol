package com.example.demo.services.implementation;

import com.example.demo.entities.Tour;
import com.example.demo.repository.TourRepository;
import com.example.demo.services.TourService;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public Tour getTourById(Long id) {
        Optional<Tour> optionalTour = tourRepository.findById(id);
        return optionalTour.orElse(null);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> SearchFilter(Tour tour) {
        Specification<Tour> spec = (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (tour.getCodeTour() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeTour"), tour.getCodeTour()));
            }
            if (tour.getCodeDistrict() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("codeDistrict"), tour.getCodeDistrict()));
            }
            if (tour.getLibelleTour() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("libelleTour"), tour.getLibelleTour()));
            }

            return predicate;
        };

        return tourRepository.findAll(spec);
    }

    @Override
    public Tour updateTour(Tour tour) {
        Tour existingTour = tourRepository.findById(tour.getId()).orElse(null);
        if (existingTour != null) {
            existingTour.setCodeDistrict(tour.getCodeDistrict());
            existingTour.setLibelleTour(tour.getLibelleTour());
            return tourRepository.save(existingTour);
        }
        return null;
    }

    @Override
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }
}
