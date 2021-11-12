package com.dama.ohrringe.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Configuration of web application.
 */
@Slf4j
@Configuration
public class WebConfigurer {
    private static final List<String> DEFAULT_PERMIT_ALL = Collections.singletonList("*");
    long DEFAULT_MAX_AGE = 1800L;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(DEFAULT_PERMIT_ALL);
        corsConfig.setAllowedMethods(DEFAULT_PERMIT_ALL);
        corsConfig.setAllowedHeaders(DEFAULT_PERMIT_ALL);
        corsConfig.setMaxAge(DEFAULT_MAX_AGE);

        log.debug("Registering CORS filter");
        source.registerCorsConfiguration("/**", corsConfig);
        source.registerCorsConfiguration("/earringApi/**", corsConfig);
//        source.registerCorsConfiguration("/management/**", corsConfig);
//        source.registerCorsConfiguration("/v2/api-docs", corsConfig);
//        source.registerCorsConfiguration("/v3/api-docs", corsConfig);
//        source.registerCorsConfiguration("/swagger-resources", corsConfig);
//        source.registerCorsConfiguration("/swagger-ui/**", corsConfig);

        return new CorsFilter(source);
    }

}
