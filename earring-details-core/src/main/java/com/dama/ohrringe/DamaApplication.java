package com.dama.ohrringe;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongock
@SpringBootApplication
public class DamaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DamaApplication.class, args);
    }

}
