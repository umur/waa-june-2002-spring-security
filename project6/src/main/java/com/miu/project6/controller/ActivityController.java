package com.miu.project6.controller;


import com.miu.project6.annotation.ExecutionTime;
import com.miu.project6.dto.ActivityDto;
import com.miu.project6.entity.ActivityLog;
import com.miu.project6.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@AllArgsConstructor
public class ActivityController {

    //@Autowired
    ActivityService activityService;

    @ExecutionTime
    @GetMapping
    public List<ActivityDto> getAll(){
        System.out.println("inside getMapping method");
        return activityService.getActivity();
    }

    @ExecutionTime
    @PostMapping
    public void createActivity(@RequestBody ActivityDto activityDto){
        //activityService.createActivity(activityDto);
        //System.out.println("inside postMapping method");
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable int id){
        activityService.deleteActivity(id);
    }

    @GetMapping("/top5")
    public List<ActivityLog> getTop5ById(@RequestParam int id1, @RequestParam int id2){
        return activityService.top5(id1, id2);
    }
}
