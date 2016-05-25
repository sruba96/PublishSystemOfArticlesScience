package ie.project.controllers;

import ie.project.domain.EmailAddress;
import ie.project.domain.User;
import ie.project.jacksonmapping.UserStatus;
import ie.project.responses.AddUserResponse;
import ie.project.responses.ShowUsersResponse;
import ie.project.service.DBService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 12.04.16.
 */
@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    DBService dbService;

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public AddUserResponse addUser(@RequestBody UserStatus userStatus) {
        AddUserResponse addUserResponse = new AddUserResponse();
        User user = dbService.findUserByEmailOrLogin(
                userStatus.getEmail(), userStatus.getLogin());

        if(user != null)
        {
            logger.info("Email or login already exist ");
            addUserResponse.setMessage("Email or login already exist");
            return addUserResponse;
        }

        user = prepareUser(userStatus);
        dbService.saveUser(user);
        addUserResponse.setResult(true);
        logger.info("User registered");
        return addUserResponse;
    }

    private User prepareUser(@RequestBody UserStatus userStatus) {
        User user = new User();
        user.setEmail(new EmailAddress(userStatus.getEmail()));
        user.setLogin(userStatus.getLogin());
        user.setPassword(userStatus.getPassword());
        return user;
    }

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public ShowUsersResponse userList() {
        ShowUsersResponse usersResponse = new ShowUsersResponse();
        usersResponse.setList(dbService.findAllUsers());
        usersResponse.setResult(true);
        return usersResponse;
    }
}
