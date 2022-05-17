package controller;


import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ActivityListingControllerRepository;
import repository.ActivityRepository;
import travel_appModel.Activity;
import travel_appModel.ActivityListing;
import travel_appModel.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/ActivityListing")
public class ActivityListingController {

    @Autowired
    private ActivityListingControllerRepository activityListingControllerRepository;

    @GetMapping("/activityListings")
    public ResponseEntity<List<ActivityListing>> getAllactivityListings(@RequestParam(required = false) String Title) {
        return (ResponseEntity<List<ActivityListing>>) activityListingControllerRepository.findAll();
    }

    @GetMapping("/activityListings/{activity_id}")
    public ResponseEntity< ActivityListing> getActivityListingById(@PathVariable("activity_id")long activity_id) {
        //return activityRepository.findById(activity_id);
        ActivityListing activityListing = activityListingControllerRepository.findById(activity_id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not exist with id :" + activity_id));
        return ResponseEntity.ok(activityListing);
    }

    @PostMapping("/activityListings")
    public ActivityListing createActivityListing(@RequestBody ActivityListing activityListing) {
        return activityListingControllerRepository.save(activityListing);
    }

    @PutMapping("/activityListings/{activity_id}")
    public ResponseEntity<ActivityListing> updateActivityListing(@PathVariable("activity_id") long activity_id, @RequestBody ActivityListing activityListing) {
        ActivityListing a = activityListingControllerRepository.findById(activity_id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not exist with id :" + activity_id));
        activityListing.setLocation(activityListing.getLocation());
        activityListing.setActivity_date(activityListing.getActivity_date());
        activityListing.setListing_date(activityListing.getListing_date());
        ActivityListing updateActivityListing = activityListingControllerRepository.save(a);
        return ResponseEntity.ok(updateActivityListing);

    }

    @DeleteMapping("/activityListings/{id}")
    public ResponseEntity<HttpStatus> deleteActivityListing (@PathVariable("activity_id") long activity_id) {
        ActivityListing activityListing = activityListingControllerRepository.findById(activity_id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not exist with id :" + activity_id));
        activityListingControllerRepository.delete(activityListing);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }




}