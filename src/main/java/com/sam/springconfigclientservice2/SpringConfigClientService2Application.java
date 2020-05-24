package com.sam.springconfigclientservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({DbSettings.class, ServerSettings.class})
@SpringBootApplication
public class SpringConfigClientService2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigClientService2Application.class, args);
    }

}
