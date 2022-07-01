package com.miu.project6.service.impl;

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
