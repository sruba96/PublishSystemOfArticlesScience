package ie.project.responses;

import ie.project.jacksonmapping.UserStatus;

import java.util.List;

/**
 * Created by pawel on 12.04.16.
 */
public class ShowUsersResponse {

    private boolean result;
    private List<UserStatus> list;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<UserStatus> getList() {
        return list;
    }

    public void setList(List<UserStatus> list) {
        this.list = list;
    }
}
