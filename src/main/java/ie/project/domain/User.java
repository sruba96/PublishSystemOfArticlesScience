package ie.project.domain;


import ie.project.jacksonmapping.UserStatus;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pawel on 11.04.16.
 */
@Entity
public class User extends AbstractEntity {

    @Column(unique = true)
    private String login;
    private char[] password;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private EmailAddress email;

    @ManyToMany(mappedBy = "users")
    private List<Project> projects;

    @OneToMany(mappedBy = "user")
    private List<File> files;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public UserStatus convert(){

        UserStatus userStatus = new UserStatus();
        userStatus.setLogin(this.getLogin());
        userStatus.setEmail(this.getEmail().toString());
        userStatus.setId(this.getId());

        return userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", projects=" + projects +
                ", files=" + files +
                '}';
    }
}
