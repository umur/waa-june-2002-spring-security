package com.miu.project6.service;



import com.miu.project6.dto.ActivityDto;
import com.miu.project6.entity.ActivityLog;

import java.util.List;

public interface ActivityService {
    public List<ActivityDto> getActivity();
    public void createActivity(ActivityDto activityDto);
    public void updateActivity(ActivityDto activityDto, int id);
    public void deleteActivity(int id);

    public List<ActivityLog> top5(int id1, int id2);
}
