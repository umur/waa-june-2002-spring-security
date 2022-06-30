package com.miu.project6.service;


import com.miu.project6.dto.ActivityDto;
import com.miu.project6.entity.ActivityLog;
import com.miu.project6.repo.ActivityRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService{

   //@Autowired
    private final ActivityRepo activityRepo;


   //@Autowired

    private final ModelMapper modelMapper;

//    @Autowired
//    public ActivityServiceImpl(ModelMapper mapper, ActivityRepo activityRepo){
//        this.modelMapper=mapper;
//        this.activityRepo=activityRepo;
//    }

    @Override
    public List<ActivityDto> getActivity() {
        return activityRepo.findAll().stream().map(activityLog -> modelMapper.map(activityLog, ActivityDto.class)).toList();
    }

    @Override
    public void createActivity(ActivityDto activityDto) {
        ActivityLog log =modelMapper.map(activityDto, ActivityLog.class);
        activityRepo.save(log);
    }

    @Override
    public void updateActivity(ActivityDto activityDto, int id) {
        ActivityLog activityLog=modelMapper.map(activityDto,ActivityLog.class);
        activityLog.setId(id);
        activityRepo.save(activityLog);
    }

    @Override
    public void deleteActivity(int id) {
        activityRepo.deleteById(id);
    }

    @Override
    public List<ActivityLog> top5(int id1, int id2) {
        return activityRepo.findTop2ByIdBetween(id1,id2);
    }

}
