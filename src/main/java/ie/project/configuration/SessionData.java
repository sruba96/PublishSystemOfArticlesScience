package ie.project.configuration;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pawel on 27.05.16.
 */
@Component
public class SessionData {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final int id = idCounter.incrementAndGet();
    private String email = null;
    private boolean emailSetted = false;
    private final Date time = Calendar.getInstance().getTime();
    private String login;
    private Long projectId;
    private boolean isProjectId;
    public SessionData() {
    }

    public SessionData(String email) {
        this.email = email;
    }

    public boolean isProjectId() {
        return isProjectId;
    }

    public void setProjectId(boolean projectId) {
        isProjectId = projectId;
    }

    public Date getTime() {
        return time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { // set once
        if (emailSetted) throw new RuntimeException("Email already setted!");
        this.email = email;
        emailSetted = true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public boolean isEmailSetted() {
        return this.emailSetted;
    }

    @Override
    public String toString() {
        return "SessionData{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", time=" + time.toString() +
                '}';
    }
}
