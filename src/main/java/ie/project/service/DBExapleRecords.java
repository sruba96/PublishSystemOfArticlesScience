package ie.project.service;

import ie.project.domain.EmailAddress;
import ie.project.domain.User;
import ie.project.repositories.FileRepository;
import ie.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by pawel on 25.05.16.
 */
public class DBExapleRecords {

    @Autowired
    DBService dbService;


    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Wacek");
        user.setLastName("Lolek");
        user.setLogin("wacuuuch");
        char[] passwd = {'a', 'b', 'c'};
        user.setPassword(passwd);
        String email = "robert@example.mail.com";
        user.setEmail(new EmailAddress(email));
        dbService.saveUser(user);
        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Zorn");
        passwd = new char[]{'x', 'y', 'z'};
        user1.setPassword(passwd);
        user1.setEmail(new EmailAddress("john_zorn@example.mail.com"));

        dbService.saveUser(user1);

        dbService.saveFile("every day", "files/4ueirumtffkjng1jevery day", "", "4ueirumtffkjng1j");
    }

}
