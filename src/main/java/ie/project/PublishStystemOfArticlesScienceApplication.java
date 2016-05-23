package ie.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublishStystemOfArticlesScienceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublishStystemOfArticlesScienceApplication.class, args);
    }

    /*I commeted this, becouse i wanna put index.html to static from templates*/

//    @Bean(name = "multipartResolver")
//    public StandardServletMultipartResolver resolver() {
//        return new StandardServletMultipartResolver();
//    }
}
