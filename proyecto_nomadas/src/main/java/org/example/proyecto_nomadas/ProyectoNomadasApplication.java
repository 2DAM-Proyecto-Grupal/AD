package org.example.proyecto_nomadas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProyectoNomadasApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoNomadasApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProyectoNomadasApplication.class);

    }

}
