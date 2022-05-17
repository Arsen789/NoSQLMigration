package controller;

import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.RatePostingRepository;
import repository.RatingRepository;
import travel_appModel.Booking;
import travel_appModel.RatePosting;
import travel_appModel.Rating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/ratePosting")

public class RatePostingController {


    @Autowired
    RatePostingRepository ratePostingRepository;

    @GetMapping("/ratePosting")
    public ResponseEntity<List<RatePosting>>getAllRatePostings(@RequestParam(required = false)String Title){
        return (ResponseEntity<List<RatePosting>>) ratePostingRepository.findAll();
    }

    @GetMapping("/ratePosting/{ratePosting_id}")
    public ResponseEntity<RatePosting>getRatePostingById(@PathVariable("ratePosting_id")long ratePosting_id){
        RatePosting ratePosting = ratePostingRepository.findById(ratePosting_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + ratePosting_id));
        return ResponseEntity.ok(ratePosting);
    }

    @PostMapping("/ratings")
    public ResponseEntity<RatePosting> createRating(@RequestBody  RatePosting ratePosting){
        RatePosting ratePosting1 = ratePostingRepository.save(ratePosting);
        return new ResponseEntity<RatePosting>(ratePosting1, HttpStatus.OK);
    }

    @PutMapping("/ratings/{ratePosting_id}")
    public ResponseEntity<RatePosting> updateRating(@PathVariable("ratePosting_id") long rating_id, @RequestBody RatePosting ratePosting ) {
        RatePosting ratePosting1 = ratePostingRepository.findById(ratePosting_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + ratePosting_id));
        ratePosting.setRating_date(ratePosting.getRating_date());
        Rating updateRating = ratePostingRepository.save(ratePosting);
        return ResponseEntity.ok(updateRating);
    }

    @DeleteMapping("/ratings/{ratePosting_id}")
    public ResponseEntity<HttpStatus> deleteRating(@PathVariable("ratePosting_id") long ratePosting_id) {
        RatePosting ratePosting1 = ratePostingRepository.findById(ratePosting_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + ratePosting_id));
        ratePostingRepository.delete(rating);
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


 */