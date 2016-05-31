package ie.project.repositories;

import ie.project.domain.Project;
import ie.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pawel on 11.04.16.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
