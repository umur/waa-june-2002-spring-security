package com.springjwt.repository;

import com.springjwt.models.OffensiveUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffensiveRepo extends CrudRepository<OffensiveUser, Integer> {

    OffensiveUser findByUserName(String name);
}
