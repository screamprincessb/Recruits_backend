package com.sense.service.config;
import com.sense.service.custom.filter.ApiFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<ApiFilter> loggingFilter() {
        FilterRegistrationBean<ApiFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiFilter());

        registrationBean.addUrlPatterns("/rest/*");

        return registrationBean;

    }
}
