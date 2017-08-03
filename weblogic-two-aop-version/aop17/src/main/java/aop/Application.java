package aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;

/**
 * Created by gkatzioura on 5/28/16.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication();
        ApplicationContext applicationContext = SpringApplication.run(Application.class,args);
    }
}
