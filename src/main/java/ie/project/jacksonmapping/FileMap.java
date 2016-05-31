package ie.project.jacksonmapping;

/**
 * Created by pawel on 12.04.16.
 */
public class FileMap {

    private String fileName;
    private String uniqueMarks;
    private String ownerLogin;
//    private String description;

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public String getUniqueMarks() {
        return uniqueMarks;
    }

    public void setUniqueMarks(String uniqueMarks) {
        this.uniqueMarks = uniqueMarks;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
