package ie.project.controllers;

import com.sun.xml.internal.bind.v2.TODO;
import ie.project.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Autowired
    DBService dbService;

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {

        try {
            saveFile(uploadfile);

            // TODO: 12.04.16 dbesrvice, i will create new File class from my domain 
            
//            ie.project.domain.File

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

}


