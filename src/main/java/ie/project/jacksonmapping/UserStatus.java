package ie.project.jacksonmapping;

/**
 * Created by pawel on 12.04.16.
 */
public class UserStatus {

    private String login;
    private char[] password;
    private String email;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
