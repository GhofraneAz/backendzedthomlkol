package com.example.demo.controllers;

import com.example.demo.entities.Tour;
import com.example.demo.services.TourService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@AllArgsConstructor
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    // Créer un tour
    @PostMapping("/createTour")
    // http://localhost:8080/api/tours/createTour
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour savedTour = tourService.createTour(tour);
        return new ResponseEntity<>(savedTour, HttpStatus.CREATED);
    }

    // Récupérer un tour par son code (ID)
    @GetMapping("/{codeTour}")
    // http://localhost:8080/api/tours/{codeTour}
    public ResponseEntity<Tour> getTourById(@PathVariable("codeTour") Long codeTour) {
        Tour tour = tourService.getTourById(codeTour);
        if (tour != null) {
            return new ResponseEntity<>(tour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Récupérer tous les tours
    @GetMapping("/getAllTours")
    // http://localhost:8080/api/tours/getAllTours
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tourList = tourService.getAllTours();
        return new ResponseEntity<>(tourList, HttpStatus.OK);
    }

    // Mettre à jour un tour
    @PutMapping("/{codeTour}")
    // http://localhost:8080/api/tours/{codeTour}
    public ResponseEntity<Tour> updateTour(@PathVariable("codeTour") Long codeTour, @RequestBody Tour tour) {
        tour.setCodeTour(codeTour);  // Assurez-vous que le codeTour est bien mis à jour dans l'objet Tour
        Tour updatedTour = tourService.updateTour(tour);
        if (updatedTour != null) {
            return new ResponseEntity<>(updatedTour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un tour
    @DeleteMapping("/{codeTour}")
    // http://localhost:8080/api/tours/{codeTour}
    public ResponseEntity<String> deleteTour(@PathVariable("codeTour") Long codeTour) {
        tourService.deleteTour(codeTour);
        return new ResponseEntity<>("Tour was deleted successfully", HttpStatus.OK);
    }
}
