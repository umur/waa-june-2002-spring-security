package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.domain.ActivityLog;
import edu.miu.springsecurity.repo.ActivityLogRepo;
import edu.miu.springsecurity.service.ActivityLogService;
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
