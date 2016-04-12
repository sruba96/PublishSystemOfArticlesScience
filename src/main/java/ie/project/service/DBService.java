package ie.project.service;

import ie.project.domain.EmailAddress;
import ie.project.domain.File;
import ie.project.domain.User;
import ie.project.jacksonmapping.UserStatus;
import ie.project.repositories.FileRepository;
import ie.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 11.04.16.
 */
@Transactional
@Service
public class DBService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

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


        userRepository.save(user);

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Zorn");
        passwd = new char[]{'x', 'y', 'z'};
        user1.setPassword(passwd);
        user1.setEmail(new EmailAddress("john_zorn@example.mail.com"));

        userRepository.save(user1);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<UserStatus> findAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserStatus> userStatusList = new ArrayList<>();

        for (User u : users) {
            UserStatus userStaus = new UserStatus();
            userStaus.setLogin(u.getLogin());
            userStaus.setEmail(u.getEmail().toString());
            userStatusList.add(userStaus);
        }
        return userStatusList;
    }

    public List<File> findAllFiles() {
        return fileRepository.findAll();
    }

    public boolean saveFile(File file) {
       if (fileRepository.save(file) == null)
           return false;
        else
           return true;
    }

}
