package com.example.userRegistration.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.userRegistration.jwt.JwtFilter;


@Configuration
public class JwtFilterConfig {
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());
       filter.addUrlPatterns("/admin/*");
    return filter;
    }

}
