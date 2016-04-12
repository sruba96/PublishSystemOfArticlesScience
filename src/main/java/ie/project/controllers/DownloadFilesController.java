package ie.project.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by pawel on 12.04.16.
 */
@Controller
public class DownloadFilesController {

    @RequestMapping(value = "/files/{fileID}", method = RequestMethod.GET)
    public void downloadFile(
            @PathVariable("fileID") String fileName,
            HttpServletResponse response) {
        try {
            String src = "files/" + fileName + ".png";
            InputStream fileInputStream = new FileInputStream(src);

            response.addHeader("Content-disposition", "attachment;filename=" + fileName + ".png");
            response.setContentType("txt/plain");

            // Copy the stream to the response's output stream.
            IOUtils.copy(fileInputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
