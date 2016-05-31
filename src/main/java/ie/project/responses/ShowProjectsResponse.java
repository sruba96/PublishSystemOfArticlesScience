package ie.project.responses;

import ie.project.domain.Project;

import java.util.List;

/**
 * Created by pawel on 31.05.16.
 */
public class ShowProjectsResponse extends BasicResponse {

    private List<Project> list;

    public ShowProjectsResponse() {
    }

    public List<Project> getList() {
        return list;
    }

    public void setList(List<Project> list) {
        this.list = list;
    }
}
