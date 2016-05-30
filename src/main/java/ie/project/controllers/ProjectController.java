package ie.project.controllers;

import ie.project.domain.User;
import ie.project.jacksonmapping.ProjectMap;
import ie.project.jacksonmapping.UserStatus;
import ie.project.responses.AddUserResponse;
import ie.project.responses.BasicResponse;
import ie.project.service.DBService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 31.05.16.
 */
@RestController
public class ProjectController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    DBService dbService;

    @RequestMapping(value = {"/addProject"}, method = RequestMethod.POST)
    public BasicResponse addProject(@RequestBody ProjectMap projectMap) {
        BasicResponse basicResponse = new BasicResponse();



        return basicResponse;
    }


}
