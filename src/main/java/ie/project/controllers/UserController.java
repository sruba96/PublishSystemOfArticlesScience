package ie.project.controllers;

import ie.project.domain.EmailAddress;
import ie.project.domain.User;
import ie.project.jacksonmapping.UserStatus;
import ie.project.responses.AddUserResponse;
import ie.project.responses.ShowUsersResponse;
import ie.project.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel on 12.04.16.
 */
@RestController
public class UserController {

    @Autowired
    DBService dbService;

    @RequestMapping(value = {"/addUser"})
    public AddUserResponse addUser(@RequestBody UserStatus userStatus){

        AddUserResponse addUserResponse = new AddUserResponse();

        User user = prepareUser(userStatus);

        dbService.saveUser(user);

        return addUserResponse;
    }

    private User prepareUser(@RequestBody UserStatus userStatus) {
        User user = new User();
        user.setEmail(new EmailAddress(userStatus.getEmail()));
        user.setLogin(userStatus.getLogin());
        user.setPassword(userStatus.getPassword());
        return user;
    }

    public ShowUsersResponse userList(){

    }
}
