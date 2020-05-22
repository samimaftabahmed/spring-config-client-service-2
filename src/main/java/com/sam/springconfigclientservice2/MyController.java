package com.sam.springconfigclientservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class MyController {

    @Autowired
    private DbSettings dbSettings;
    @Autowired
    private ServerSettings serverSettings;

    @GetMapping("/")
    public String getSettings() {

        return dbSettings.toString();
    }

    @GetMapping("refresh")
    public void refresh() {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> request = new HttpEntity<>(new Object());
        String url = "http://localhost:" + serverSettings.getPort() + "/actuator/refresh";
        restTemplate.postForObject(url, request, Object.class);
    }
}
