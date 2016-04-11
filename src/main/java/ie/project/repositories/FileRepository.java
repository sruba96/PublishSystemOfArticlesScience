package ie.project.repositories;

import ie.project.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pawel on 11.04.16.
 */
public interface FileRepository extends JpaRepository<File, Long> {

}
