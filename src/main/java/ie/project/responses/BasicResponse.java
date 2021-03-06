package ie.project.responses;

/**
 * Created by pawel on 11.04.16.
 */
public class BasicResponse {

    private boolean result;

    private String message;


    public BasicResponse() {
        this.result = false;
    }

    public BasicResponse(boolean result) {
        this.result = result;
    }

    public BasicResponse(String message) {
        this.message = message;
    }

    public BasicResponse(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
