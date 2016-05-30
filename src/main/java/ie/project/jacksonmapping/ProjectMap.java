package ie.project.jacksonmapping;

/**
 * Created by pawel on 31.05.16.
 */
public class ProjectMap {

    private String name;
    private String description;

    public ProjectMap() {
    }

    public ProjectMap(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "ProjectMap{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
