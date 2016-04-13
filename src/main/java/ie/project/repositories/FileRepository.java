package ie.project.repositories;

import ie.project.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel on 11.04.16.
 */
@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    File findByUniqueMarks(String uniqueMarks);
}
