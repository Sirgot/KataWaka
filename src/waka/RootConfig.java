package waka;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@ComponentScan (basePackages = {"waka"}, excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {
    Boolean test = Boolean.TRUE;
    public static void main(String[] args) {
        //!important the same name of the class
        SpringApplication.run(RootConfig.class, args);
    }
}
