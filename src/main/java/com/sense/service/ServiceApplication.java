package com.sense.service;

import com.sense.backend.common.helper.HBHelper;
import com.sense.service.util.BuildTime;
import com.sense.service.conts.AppConts;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ServletComponentScan
@EnableSwagger2
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
    public Docket productApi() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sense.service.rest.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiEndPointsInfo() {
        try {
            return new ApiInfoBuilder()
                    .title(AppConts.INFO_DESC)
                    .description("Last Build : " + BuildTime.getLastModifiedDate())
                    .license("By : Sense Info Tech")
                    //.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                    .version(AppConts.INFO_VERSION)
                    .build();
        } catch (IOException ex) {
            Logger.getLogger(ServiceApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ServiceApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(true)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceApplication.class);
    }

}
