package com.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MainWebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("com.web");
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher"
                , new DispatcherServlet(root));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }
}
