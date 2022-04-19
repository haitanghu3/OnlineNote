package com.werun.onlinenote_backend;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class OnlineNoteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineNoteBackendApplication.class, args);
    }

}
