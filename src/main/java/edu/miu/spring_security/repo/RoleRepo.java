package edu.miu.spring_security.repo;

import edu.miu.spring_security.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,Integer> {
    Role findByRole(String email);
}
