package ie.project.controllers;

import ie.project.responses.ShowFileResponse;
import ie.project.service.DBService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by pawel on 12.04.16.
 */
@Controller
public class DownloadFilesController {

    @Autowired
    DBService dbService;

    @RequestMapping(value = "/showfiles" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ShowFileResponse filesList(){
        ShowFileResponse showFileResponse = new ShowFileResponse();
        showFileResponse.setFileList(dbService.findAllFiles());
        showFileResponse.setResult(true);
        return showFileResponse;
    }

    @RequestMapping(value = "/files/{fileID}", method = RequestMethod.GET)
    public void downloadFile(
            @PathVariable("fileID") String fileName,
            HttpServletResponse response) {
        try {
            String src = "files/" + fileName;
            // TODO: 12.04.16 I have problem with extension :(  
            InputStream fileInputStream = new FileInputStream(src);

            response.addHeader("Content-disposition", "attachment;filename=" + fileName);
            response.setContentType("txt/plain");

            // Copy the stream to the response's output stream.
            IOUtils.copy(fileInputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}