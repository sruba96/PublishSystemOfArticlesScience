package ie.project.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.SecureRandom;


/**
 * Created by pawel on 08.04.16.
 */
@Controller
public class UploadFilesController {

    private SecureRandom random = new SecureRandom();

    public String takeUnique() {
        return new BigInteger(80, random).toString(32);
    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {

        try {
            saveFile(uploadfile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    } // method uploadFile

    private void saveFile(@RequestParam("file") MultipartFile uploadfile) throws IOException {

        // Get the filename and build the local file path (be sure that the
        // application have write permissions on such directory) GG - question
        String filename = takeUnique() + uploadfile.getOriginalFilename();
        String directory = "files/";
        String filepath = Paths.get(directory, filename).toString();

        // Save the file locally
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(filepath)));
        stream.write(uploadfile.getBytes());
        stream.close();

    }

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


