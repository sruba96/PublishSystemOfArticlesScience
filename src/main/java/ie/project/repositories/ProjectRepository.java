package ie.project.repositories;

import ie.project.domain.Project;
import ie.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by pawel on 11.04.16.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByOwner(String owner);

    Project findById(Long id);


}
