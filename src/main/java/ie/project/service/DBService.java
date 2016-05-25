package ie.project.service;

import ie.project.domain.EmailAddress;
import ie.project.domain.File;
import ie.project.domain.User;
import ie.project.jacksonmapping.FileMap;
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

        saveFile("every day", "files/4ueirumtffkjng1jevery day", "", "4ueirumtffkjng1j");
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

    public List<FileMap> findAllFiles() {

        List<File> fileList = fileRepository.findAll();
        List<FileMap> fileMapList = new ArrayList<>();
        for (File f : fileList) {

            FileMap fileMap = new FileMap();
            fileMap.setFileName(f.getName());
            fileMap.setUniqueMarks(f.getUniqueMarks());
            fileMapList.add(fileMap);
        }
        return fileMapList;
    }

    public boolean saveFile(String filename, String filepath , String extension , String uniqueMarks) {

        File file = new File();
        file.setName(filename);
        file.setSource(filepath);
        file.setExtension(extension);
        file.setUniqueMarks(uniqueMarks);

        if (fileRepository.save(file) != null)
            return true;
        return false;
    }

    public File findFile(String uniqueMarks){
        return fileRepository.findByUniqueMarks(uniqueMarks);
    }
}
