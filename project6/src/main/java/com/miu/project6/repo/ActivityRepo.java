package com.miu.project6.repo;


import com.miu.project6.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepo extends JpaRepository<ActivityLog,Integer> {

    public List<ActivityLog> findTop2ByIdBetween(Integer id1, Integer id2);
    //public List<ActivityLog> findAllOrderById( Integer id);
}
