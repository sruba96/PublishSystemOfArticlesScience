package ie.project.controllers;

import ie.project.configuration.SessionData;
import ie.project.domain.File;
import ie.project.responses.BasicResponse;
import ie.project.responses.ShowFileResponse;
import ie.project.service.DBService;

import org.apache.log4j.Logger;
import org.h2.util.IOUtils;
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

    private static final Logger logger = Logger.getLogger(DownloadFilesController.class);


    @Autowired
    DBService dbService;

    @Autowired
    SessionData sessionData;

    @RequestMapping(value = "/showfiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ShowFileResponse filesList() {
        logger.info("showFiles from project");
        ShowFileResponse showFileResponse = new ShowFileResponse();

        if (!sessionData.isEmailSetted()) {
            showFileResponse.setResult(false);
            logger.info("you must be logged");

        } else {
            showFileResponse.setFileList(dbService.findAllFilesFromProject(sessionData.getProjectId()));
            showFileResponse.setResult(true);
            logger.info("files found");
        }
        return showFileResponse;
    }

    @RequestMapping(value = "/files/{fileID}", method = RequestMethod.GET)
    public void downloadFile(
            @PathVariable("fileID") String uniqueMarks,
            HttpServletResponse response) {

        try {
            File file = dbService.findFile(uniqueMarks);

            String src = file.getSource();
            InputStream fileInputStream = new FileInputStream(src);
            response.addHeader("Content-disposition", "attachment;filename="
                    + file.getName());
            response.setContentType("txt/plain");

//            fileDownloadResponse.setUrl(src);
//            fileDownloadResponse.setResult(true);
//             Copy the stream to the response's output stream.
            IOUtils.copy(fileInputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
