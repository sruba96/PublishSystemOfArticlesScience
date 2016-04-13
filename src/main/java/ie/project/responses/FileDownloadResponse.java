package ie.project.responses;

/**
 * Created by pawel on 13.04.16.
 */
public class FileDownloadResponse {

    private boolean result = false;

    private String url;

    public boolean isResult(){
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
