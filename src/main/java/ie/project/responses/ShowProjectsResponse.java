package ie.project.responses;

import ie.project.domain.Project;
import ie.project.jacksonmapping.ProjectMap;

import java.util.List;

/**
 * Created by pawel on 31.05.16.
 */
public class ShowProjectsResponse extends BasicResponse {

    private List<ProjectMap> list;

    public ShowProjectsResponse() {
    }

    public List<ProjectMap> getList() {
        return list;
    }

    public void setList(List<ProjectMap> list) {
        this.list = list;
    }
}
