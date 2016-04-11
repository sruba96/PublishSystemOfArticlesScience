package ie.project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pawel on 11.04.16.
 */
public class HomeController {

    @RequestMapping
    public String index(){

        return "index";
    }

}
