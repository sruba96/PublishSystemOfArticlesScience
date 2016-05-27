package ie.project.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by pawel on 27.05.16.
 */
@Configuration
public class AppConfiguration {

    private static final Logger logger = Logger.getLogger(AppConfiguration.class);

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionData sessionData() {
        logger.info("Session bean init");
        return new SessionData();
    }
}
