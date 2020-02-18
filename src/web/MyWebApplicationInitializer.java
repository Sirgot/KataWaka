package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import waka.control.Controler;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@Controller
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    private DispatcherServlet servlet;

    @Override
    public void onStartup (ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(Controler.class);
        ac.refresh();

        // Create and register the DispatcherServlet
        servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic home = servletCxt.addServlet("WakaHome", servlet);
        home.setLoadOnStartup(1);
        home.addMapping("/");

        ServletRegistration.Dynamic users = servletCxt.addServlet("Waka", servlet);
        users.setLoadOnStartup(1);
        users.addMapping("/Waka/*");
    }
}
