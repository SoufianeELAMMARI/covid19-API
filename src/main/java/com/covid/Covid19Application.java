package com.covid;

import com.covid.service.CovidApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created by @author ELAMMARI Soufiane
 * elammarisoufiane@gmail.com
 * on 27/04/2020
 */

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class Covid19Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Covid19Application.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    public CovidApiClient covidApiClient() {
        return null;
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}


