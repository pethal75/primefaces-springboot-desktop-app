package com.javaservices;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PrimefacesSpringbootDesktopApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PrimefacesSpringbootDesktopApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrimefacesSpringbootDesktopApplication.class);
    }

    @PostConstruct
    public void showBrowser() {
        Runnable startJavyFX = JavaFXBrowser::openBrowser;
        new Thread(startJavyFX).start();
    }
}
