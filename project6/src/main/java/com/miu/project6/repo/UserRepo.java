package com.miu.project6.repo;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}
