package edu.miu.springsecurity.repo;


import edu.miu.springsecurity.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
  User findByUserName(String userName);
}
