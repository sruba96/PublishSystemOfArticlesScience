package ie.project.responses;

import ie.project.jacksonmapping.FileMap;

import java.util.List;

/**
 * Created by pawel on 12.04.16.
 */
public class ShowFileResponse {

    private boolean result = false;

    private List<FileMap> fileList;

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public List<FileMap> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileMap> fileList) {
        this.fileList = fileList;
    }
}
