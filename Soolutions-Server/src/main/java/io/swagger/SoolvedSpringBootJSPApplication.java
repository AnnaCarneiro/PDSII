package io.swagger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api" , "io.swagger.configuration", "io.swagger.model", "io.swagger.entity"})
public class SoolvedSpringBootJSPApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SoolvedSpringBootJSPApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SoolvedSpringBootJSPApplication.class, args);
    }



}
