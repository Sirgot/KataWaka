package waka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"waka"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    public static void main (String[] args) {
        SpringApplication.run(RootConfig.class, args);
        //!important the same name of the class
        SpringApplication application = new SpringApplication(WebApplicationType.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
//        application.run(CustomizationBean.class,  args);
//        SpringApplication.run(Controler.class,"/");
    }


}
