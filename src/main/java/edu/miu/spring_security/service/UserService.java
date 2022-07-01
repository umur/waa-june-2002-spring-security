package edu.miu.spring_security.service;

import edu.miu.spring_security.dto.UserDto;
import edu.miu.spring_security.entity.User;

import java.util.List;

public interface UserService {
    void save(UserDto user);

    public void updateUser(UserDto user, Integer id);
    void delete(int id);

    User getById(int id);

    List<UserDto> getAll();
}
