package ie.project.responses;

import ie.project.domain.User;

import java.util.List;

/**
 * Created by pawel on 12.04.16.
 */
public class ShowUsersResponse {

    private boolean result;
    private List<User> list;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
