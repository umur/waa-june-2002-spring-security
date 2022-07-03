package miu.edu.springsecurity.repository;
import miu.edu.springsecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
