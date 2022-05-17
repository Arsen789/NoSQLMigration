package controller;


import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.GuideRepository;
import repository.RatingRepository;
import travel_appModel.Booking;
import travel_appModel.Guide;
import travel_appModel.Rating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/guide")

public class GuideController {
    @Autowired
    GuideRepository guideRepository;

    @GetMapping("/guides")
    public ResponseEntity<List<Guide>>getAllGuides(@RequestParam(required = false)String Title){
        return (ResponseEntity<List<Guide>>) guideRepository.findAll();
    }

    /*

    @GetMapping("/guides/{guide_id}")
    public ResponseEntity<Guide>getGuideById(@PathVariable("id")long guide_id){
        Guide guide = guideRepository.findById(guide_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + guide_id));
        return ResponseEntity.ok(guide);
    }



    @PostMapping("/guides")
    public ResponseEntity<Guide> createGuide(@RequestBody Guide guide){
        Guide guide1 = RatingRepository.save(guide);
        return new ResponseEntity<Booking>(guide1,HttpStatus.OK);
    }

    @PutMapping("/guides/{guide_id}")
    public ResponseEntity<Rating> updateGuide(@PathVariable("guide_id") long guide_id, @RequestBody Booking guide ) {
        Rating rating1 = guideRepository.findById(guide_id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id :" + guide_id));
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


     */

}
