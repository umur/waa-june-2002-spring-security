package com.cs545waa.lab06.repository;

import com.cs545waa.lab06.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UaaRepo extends CrudRepository<AppUser, Integer> {
    public AppUser findUsersByEmail(String email);
}
