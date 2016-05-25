package ie.project.repositories;

import ie.project.domain.EmailAddress;
import ie.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pawel on 11.04.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailOrLogin(EmailAddress emailAddress, String login);

}
