package service;

import org.springframework.stereotype.Service;
import travel_appModel.Activity;

import java.util.HashSet;
import java.util.Set;

@Service
public class ActivityService {

    private Set<Activity> activities = new HashSet<>();

    //return all activities
    public Set<Activity> getAllActivities() {
        return activities;
    }






}
