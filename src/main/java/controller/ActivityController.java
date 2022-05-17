package controller;


import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.ActivityRepository;
import travel_appModel.Activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    //@Autowired// ?? private ActivityService activityService;


    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getAllActivities(@RequestParam(required = false) String Title) {
        return (ResponseEntity<List<Activity>>) activityRepository.findAll();
    }

    @GetMapping("/activities/{activity_id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable("activity_id")long activity_id) {
        //return activityRepository.findById(activity_id);
        Activity activity = activityRepository.findById(activity_id)
                .orElseThrow(() -> new ResourceNotFoundException("ActivityRepository not exist with id :" + activity_id));
        return ResponseEntity.ok(activity);
    }

    @PostMapping("/activities")
    public Activity createActivity(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }

    @PutMapping("/activities/{activity_id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("activity_id") long activity_id, @RequestBody Activity activity) {
        Activity a = activityRepository.findById(activity_id)
                .orElseThrow(() -> new ResourceNotFoundException("ActivityRepository not exist with id :" + activity_id));
        activity.setTitle(activity.getTitle());
        activity.setDescription(activity.getDescription());
        Activity updatedUser = activityRepository.save(activity);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<HttpStatus> deleteActivity (@PathVariable("activity_id") long activity_id) {
        Activity activity = activityRepository.findById(activity_id)
                .orElseThrow(() -> new ResourceNotFoundException("ActivityRepository not exist with id :" + activity_id));
        activityRepository.delete(activity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<HttpStatus>( HttpStatus.OK);
    }




}
