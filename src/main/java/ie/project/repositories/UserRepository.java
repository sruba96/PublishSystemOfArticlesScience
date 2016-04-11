package ie.project.repositories;

import ie.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pawel on 11.04.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
