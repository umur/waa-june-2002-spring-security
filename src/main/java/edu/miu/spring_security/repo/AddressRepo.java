package edu.miu.spring_security.repo;

import edu.miu.spring_security.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {

    List<Address> findAll();
}
