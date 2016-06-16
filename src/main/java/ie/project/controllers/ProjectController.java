package ie.project.controllers;

import ie.project.configuration.SessionData;
import ie.project.domain.Project;
import ie.project.domain.User;
import ie.project.jacksonmapping.ProjectMap;
import ie.project.jacksonmapping.UserStatus;
import ie.project.responses.AddUserResponse;
import ie.project.responses.BasicResponse;
import ie.project.responses.ShowProjectsResponse;
import ie.project.service.DBService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by pawel on 31.05.16.
 */
@RestController
public class ProjectController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    DBService dbService;

    @Autowired
    SessionData sessionData;

    @RequestMapping(value = {"/addProject"}, method = RequestMethod.POST)
    public BasicResponse addProject(@RequestBody ProjectMap projectMap) {

        if (!sessionData.isEmailSetted()) {
            logger.info("You must be logged");
            return new BasicResponse("You must be logged");
        }
        try {
            User user = dbService.findUserByEmailOrLogin(sessionData.getLogin());
            dbService.saveProject(projectMap, user.getLogin());
        } catch (Exception e) {
            logger.info("DataBase problem");
            return new BasicResponse("DataBase problem");
        }

        return new BasicResponse(true);

    }

    @RequestMapping(value = {"/showProject"}, method = RequestMethod.POST)
    public ShowProjectsResponse showProject() {

        ShowProjectsResponse showProjectsResponse = new ShowProjectsResponse();
        List<Project> projects = dbService.findProjectByOwner(sessionData.getLogin());
//        ProjectMap projectMap = new ProjectMap(project.getName(), project.getDescription());
        List<ProjectMap> projectMapsList = new ArrayList<ProjectMap>();


        for (Project project : projects) {
            ProjectMap projectMap = new ProjectMap(project.getName(), project.getDescription(), project.getId());
            projectMapsList.add(projectMap);
        }

        showProjectsResponse.setList(projectMapsList);
        showProjectsResponse.setResult(true);

        return showProjectsResponse;

    }

/*
    @RequestMapping(value = {"/show"}, method = RequestMethod.POST)
    public ShowProjectsResponse showProject() {

        ShowProjectsResponse showProjectsResponse = new ShowProjectsResponse();
        showProjectsResponse.setList(dbService.findProjectByOwner(sessionData.getLogin()));
        showProjectsResponse.setResult(true);

        return showProjectsResponse;

    }
*/

    @RequestMapping(value = {"/chooseProject"}, method = RequestMethod.POST)
    public BasicResponse chooseProject(@RequestBody Long id) {

        logger.info(id);
        sessionData.setProjectId(id);


        logger.info("choose project");
        return new BasicResponse(true);
    }

    @RequestMapping(value = {"/inviteUser"}, method = RequestMethod.POST)
    public BasicResponse inviteUser(@RequestBody Long id) {

        logger.info(id);
        if(!sessionData.isProjectId())
        {
            logger.info("invite user error");
            return null;
        }
        dbService.inviteUser(id, sessionData.getProjectId());

        logger.info("invite user");
        return new BasicResponse(true);
    }

}
