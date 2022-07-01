package edu.miu.spring_security.repo;

import edu.miu.spring_security.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

    List<User> findAll();

    User findByEmail(String email);

}
