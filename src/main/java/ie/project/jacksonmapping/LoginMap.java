package ie.project.jacksonmapping;

import java.util.Arrays;

/**
 * Created by pawel on 27.05.16.
 */
public class LoginMap {

    private String loginOrEmail;
    private char[] password;

    public String getLoginOrEmail() {
        return loginOrEmail;
    }

    public void setLoginOrEmail(String loginOrEmail) {
        this.loginOrEmail = loginOrEmail;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginMap{" +
                "loginOrEmail='" + loginOrEmail + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
