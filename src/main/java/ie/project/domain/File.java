package ie.project.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.crypto.Data;

/**
 * Created by pawel on 11.04.16.
 */
@Entity
public class File extends AbstractEntity {

    private String name;
    private String source;
    private String extension;
    private String uniqueMarks;
//    private Data data;

    @ManyToOne
    User user;

    @ManyToOne
    Project project;

    public File() {
    }

    public File(String name, String source, String extension, String uniqueMarks) {
        this.name = name;
        this.source = source;
        this.extension = extension;
        this.uniqueMarks = uniqueMarks;
    }

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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUniqueMarks() {
        return uniqueMarks;
    }

    public void setUniqueMarks(String uniqueMarks) {
        this.uniqueMarks = uniqueMarks;
    }
}
