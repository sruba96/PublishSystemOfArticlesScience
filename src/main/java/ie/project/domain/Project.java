package ie.project.domain;

import ie.project.jacksonmapping.ProjectMap;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 11.04.16.
 */
@Entity
public class Project extends AbstractEntity {

    private String name;
    private String description;
    private String owner;

    @ManyToMany
    private List<User> users = new ArrayList<User>();

    @OneToMany(mappedBy = "project")
    private List<File> files = new ArrayList<File>();

    public Project() {
    }

    public Project(String name, String description, String owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;

    }

    public Project(ProjectMap projectMap, String owner) {
        this.name = projectMap.getName();
        this.description = projectMap.getDescription();
        this.owner = owner;

    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFiles(File file) {
        files.add(file);
    }

    public void removeFile(int index) {
        files.remove(index);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int index) {
        users.remove(index);
    }



    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", users=" + users +
                ", files=" + files +
                '}';
    }
}
