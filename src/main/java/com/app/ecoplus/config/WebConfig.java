package com.app.ecoplus.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("") // URL do frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//    	registry.addViewController("/").setViewName("/index.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

}
