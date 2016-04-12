package ie.project.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by pawel on 11.04.16.
 */
@Entity
public class Project extends AbstractEntity {

    private String name;

    @ManyToMany
    private List<User> users;

    @OneToMany(mappedBy = "project")
    private List<File> files;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
