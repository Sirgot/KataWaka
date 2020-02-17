package web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import waka.control.Controler;

public class MainServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses () {
        return new Class<?>[]{Controler.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses () {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings () {
        return new String[] {"/"};
    }
}
