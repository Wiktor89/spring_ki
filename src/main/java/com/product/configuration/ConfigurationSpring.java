package com.product.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.awt.*;
import java.util.Random;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.product")
@EnableScheduling
public class ConfigurationSpring extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler ("/WEB-INF/pages/**").addResourceLocations ("/pages/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolwer() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver ();
        resolver.setPrefix ("/WEB-INF/pages");
        resolver.setSuffix (".jsp");
        resolver.setViewClass (JstlView.class);
        return resolver;
    }

    @Bean
    public Color color() {
        Random random = new Random ();
        return new Color (random.nextInt (255), random.nextInt (255), random.nextInt (255));
    }
}
