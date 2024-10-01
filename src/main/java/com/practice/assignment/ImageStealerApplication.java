package com.practice.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@EnableCaching
@SpringBootApplication
public class ImageStealerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImageStealerApplication.class);
    }

    @Bean
    public RestClient getRestClient() {
        return RestClient.create();
    }
}
