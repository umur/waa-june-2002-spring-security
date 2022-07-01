package com.example.spring_jwt.service.impl;

import com.example.spring_jwt.entity.ActivityLog;
import com.example.spring_jwt.repository.ActivityLogRepo;
import com.example.spring_jwt.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
  private final ActivityLogRepo activityLogRepo;

  public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo) {
    this.activityLogRepo = activityLogRepo;
  }

  @Override
  public void save(ActivityLog a) {
    activityLogRepo.save(a);
  }
}
