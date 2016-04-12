package ie.project.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by pawel on 11.04.16.
 */
@Entity
public class File extends AbstractEntity {

    private String name;
    private String source;

    @ManyToOne
    User user;

    @ManyToOne
    Project project;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
