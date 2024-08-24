package com.app.ecoplus.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//    	registry.addViewController("/").setViewName("/index.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

}
