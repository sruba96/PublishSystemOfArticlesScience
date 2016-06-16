package ie.project.service;

import ie.project.configuration.AppConfiguration;
import ie.project.domain.EmailAddress;
import ie.project.domain.File;
import ie.project.domain.Project;
import ie.project.domain.User;
import ie.project.jacksonmapping.FileMap;
import ie.project.jacksonmapping.ProjectMap;
import ie.project.jacksonmapping.UserStatus;
import ie.project.repositories.FileRepository;
import ie.project.repositories.ProjectRepository;
import ie.project.repositories.UserRepository;
import org.apache.log4j.Logger;
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

    private static final Logger logger = Logger.getLogger(AppConfiguration.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Wacek");
        user.setLastName("Lolek");
        user.setLogin("wacek");
        char[] passwd = {'a', 'b', 'c'};
        user.setPassword(passwd);
        String email = "wacek@example.mail.com";
        user.setEmail(new EmailAddress(email));
        userRepository.save(user);
        User user1 = new User();
        user1.setLogin("Janek");
        user1.setFirstName("John");
        user1.setLastName("Zorn");
        passwd = new char[]{'x', 'y', 'z'};
        user1.setPassword(passwd);
        user1.setEmail(new EmailAddress("john_zorn@example.mail.com"));

        userRepository.save(user1);


        File file = new File();
        file.setExtension("");
        file.setUniqueMarks("4ueirumtffkjng1j");
        file.setName("every day");
        file.setSource("files/4ueirumtffkjng1jevery day");


        Project project = new Project();
        project.setName("Wykuwanie");
        project.setOwner("wacek");
        project.setDescription("bardzo fajny artykuł, na temat wykuwania stali");
        project.addUser(user);
        project.addFiles(file);
        fileRepository.save(file);
        projectRepository.save(project);

        project = new Project();
        project.setName("manie");
        project.setOwner("jacek");
        project.setDescription("bardzo fajny artykuł, na temat wykuwania stali");
        project.addUser(user1);
        projectRepository.save(project);

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmailOrLogin(String emailOrLogin) {
        User user;
        EmailAddress emailAddress;
        try {
            emailAddress = new EmailAddress(emailOrLogin.trim());
            user = userRepository.findByEmail(emailAddress);
            logger.info("Email or login - find by email address");
        } catch (Exception e) {
            logger.info("Email or login - find by login");
            user = userRepository.findByLogin(emailOrLogin);
        }
        return user;

    }

    public User findUserByEmailOrLogin(String email, String login) {
        EmailAddress emailAddress = new EmailAddress(email.trim());

        User user = userRepository.findByEmailOrLogin(emailAddress, login);
        return user;
    }


    ///////////////////////////////////////////////////////////////////////////
    // This code must be changed
    ///////////////////////////////////////////////////////////////////////////
    public List<UserStatus> findUserToInvite(Long projectId) {


        Project project = projectRepository.findById(projectId);

        List<User> all = userRepository.findAll();
//        logger.info(all.toString());
        List<User> userList = project.getUsers();
//        logger.info(userList.toString());

        List<UserStatus> userStatusList = new ArrayList<>();
        all.removeAll(userList);
//        logger.info(all.toString());


        for (User u : all) {
            UserStatus userStaus = u.convert();
            userStatusList.add(userStaus);
        }
//        logger.info(userStatusList.toString());

        return userStatusList;
    }

    public Boolean inviteUser(Long userId, Long projectId){
        User user = userRepository.findById(userId);
        Project project = projectRepository.findById(projectId);

        project.addUser(user);
        user.addProject(project);

        projectRepository.save(project);
        userRepository.save(user);

        return true;
    }

    ///////////////////////////////////////////////////////////////////////////
    // end
    ///////////////////////////////////////////////////////////////////////////

    public List<UserStatus> findAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserStatus> userStatusList = new ArrayList<>();

        for (User u : users) {
            UserStatus userStaus = u.convert();
            userStatusList.add(userStaus);
        }
        return userStatusList;
    }




    public List<FileMap> findAllFilesFromProject(Long id) {

        Project project = projectRepository.findById(id);
        List<File> fileList = project.getFiles();

        List<FileMap> fileMapList = new ArrayList<>();
        for (File f : fileList) {

            FileMap fileMap = new FileMap();
            fileMap.setFileName(f.getName());
            fileMap.setUniqueMarks(f.getUniqueMarks());
            fileMapList.add(fileMap);
        }
        return fileMapList;
    }

    public boolean saveFile(String filename, String filepath, String extension, String uniqueMarks, String ownerLogin) {

        File file = new File();
        file.setName(filename);
        file.setSource(filepath);
        file.setExtension(extension);
        file.setUniqueMarks(uniqueMarks);
        file.setOwnerLogin(ownerLogin);

        if (fileRepository.save(file) != null)
            return true;
        return false;
    }

    public boolean saveFile(File file) {

        if (fileRepository.save(file) != null)
            return true;
        return false;
    }

    public File findFile(String uniqueMarks) {
        return fileRepository.findByUniqueMarks(uniqueMarks);
    }


    public boolean saveProject(ProjectMap projectMap, String user) {
        Project project = new Project(projectMap, user);
        project.addUser(findUserByEmailOrLogin(user));
        if (projectRepository.save(project) != null)
            return true;
        return false;
    }

    public boolean saveProject(Project project) {

        if (projectRepository.save(project) != null)
            return true;
        return false;
    }

    public List<Project> findProjectByOwner(String owner) {
        return projectRepository.findByOwner(owner);
    }
//
//    public List<Project> findProjectByUsersList(User user){
//        return projectRepository.findByProjectUsers(user);
//    }

    public Project findProjectById(Long id) {
        return projectRepository.findById(id);
    }
}
