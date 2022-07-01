package com.example.lab6.repo;

import org.springframework.data.repository.CrudRepository;
import com.sudip.lab5.entity.User;

public interface UserRepo extends CrudRepository<User,Integer> {
}
