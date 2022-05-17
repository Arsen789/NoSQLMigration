package controller;


import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.RatingRepository;
import travel_appModel.Booking;
import travel_appModel.Rating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/rating")

public class RatingController {
    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/rating")
    public ResponseEntity<List<Rating>>getAllRatings(@RequestParam(required = false)String Title){
        return (ResponseEntity<List<Rating>>) ratingRepository.findAll();
    }

    @GetMapping("/ratings/{rating_id}")
    public ResponseEntity<Rating>getRatingById(@PathVariable("id")long rating_id){
        Rating rating = ratingRepository.findById(rating_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + rating_id));
        return ResponseEntity.ok(rating);
    }

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingRepository.save(rating);
        return new ResponseEntity<Rating>(rating1,HttpStatus.OK);
    }

    @PutMapping("/ratings/{rating_id}")
    public ResponseEntity<Rating> updateRating(@PathVariable("rating_id") long rating_id, @RequestBody Rating rating ) {
        Rating rating1 = ratingRepository.findById(rating_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + rating_id));
        rating.setComment(rating.getComment());
        rating.setSafety(rating.getSafety());
        rating.setQuality(rating.getQuality());
        Rating updateRating = ratingRepository.save(rating);
        return ResponseEntity.ok(updateRating);
    }

    @DeleteMapping("/ratings/{rating_id}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable("rating_id") long rating_id) {
        Rating rating = ratingRepository.findById(rating_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + rating_id));
        ratingRepository.delete(rating);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }

    @DeleteMapping("/ratings")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        ratingRepository.deleteAll();
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }



}