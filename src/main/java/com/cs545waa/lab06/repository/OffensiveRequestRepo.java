package com.cs545waa.lab06.repository;

import com.cs545waa.lab06.entity.OffensiveRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffensiveRequestRepo extends CrudRepository<OffensiveRequest,Long> {
}
