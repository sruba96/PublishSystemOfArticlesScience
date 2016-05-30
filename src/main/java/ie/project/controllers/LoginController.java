package ie.project.controllers;

import ie.project.configuration.SessionData;
import ie.project.configuration.StaticAppConfiguration;
import ie.project.domain.User;
import ie.project.jacksonmapping.LoginMap;
import ie.project.responses.BasicResponse;
import ie.project.service.DBService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by pawel on 27.05.16.
 */
@RestController
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    DBService dbService;

    @Autowired
    SessionData sessionData;


    @RequestMapping(value = "/logging", method = RequestMethod.POST)
    public BasicResponse login(@RequestBody LoginMap loginMap, HttpSession httpSession) {

        if (checkLoggedIn(httpSession).getResult())
            return new BasicResponse("Still logged");

        User user = dbService.findUserByEmailOrLogin(loginMap.getLoginOrEmail());
        if (user == null) {
            logger.info("Invalid login or email");
            return new BasicResponse("Invalid login or password");
        } else if (user.getPassword().equals(loginMap.getPassword())) {
            logger.info("Invalid password");
            return new BasicResponse("Invalid login or password");
        }

        sessionData.setEmail(user.getEmail().toString());
        httpSession.setAttribute(httpSession.getId(), sessionData);
        httpSession.setMaxInactiveInterval(StaticAppConfiguration.SESSION_TIME);

        logger.info(user.getLogin() + " logged");
        return new BasicResponse(true, user.getLogin() + " logged");

    }

    @RequestMapping(value = "/checkLoggedIn", method = RequestMethod.POST)
    public BasicResponse checkLoggedIn(HttpSession httpSession) {

        try {
            if (httpSession.getAttribute(httpSession.getId()) != null) {
                // still logged
                logger.info("Session is active");
                if (!sessionData.isEmailSetted())
                    sessionData = (SessionData) httpSession.getAttribute(httpSession.getId());
                return new BasicResponse(true, sessionData.getEmail());
            } else {
                //not logged
                logger.info("User not logged");
                return new BasicResponse(false, "User not logged");
            }

        } catch (IllegalStateException e) {
            return new BasicResponse("Session expired");
            //session expired
        }
    }

    @RequestMapping(value = "/logout2", method = RequestMethod.POST)
    public BasicResponse logout(HttpSession httpSession) {

        try {
            httpSession.invalidate();
            sessionData = new SessionData();
        } catch (IllegalStateException e) {
        }


        return new BasicResponse(true, "Logged out");

    }
}
