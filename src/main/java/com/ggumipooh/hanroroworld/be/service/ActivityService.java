package com.ggumipooh.hanroroworld.be.service;

import com.ggumipooh.hanroroworld.be.Repository.ActivityRepository;
import com.ggumipooh.hanroroworld.be.model.activity.Activity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

}
