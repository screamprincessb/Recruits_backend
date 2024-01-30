package com.sense.service;

import com.sense.backend.common.helper.HBHelper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sense.service.rest.controller", "com.sense.service.config",
    "com.sense.service.validate"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //, SecurityAutoConfiguration.class
public class ServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @PostConstruct
    private void init() {
        System.out.println("--------- Init Service ---------");
        HBHelper.instance();

    }

    @PreDestroy
    private void cleanup() {
        System.out.println("--------- Cleanup Service ---------");
        HBHelper.instance().context().close();

    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Recruits App API")
                .version("1.0")
                .contact(new Contact()
                        .name("Sense Info Tech Software")
                        .url("http://www.sense-infotech.com/")
                        .email("sense@sense-infotech.com")));
    }

    @Bean
    public GroupedOpenApi GSBAppApi() {
        final String[] packagesToScan = {"com.sense.service.rest.controller"};
        return GroupedOpenApi.builder()
                .group("Recruits App API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/**")
                .build();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceApplication.class);
    }
}
