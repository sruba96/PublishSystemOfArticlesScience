package ie.project.responses;

/**
 * Created by pawel on 12.04.16.
 */
public class AddUserResponse {

    private boolean result = false;

    private String message;

    public boolean isResult(){
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
