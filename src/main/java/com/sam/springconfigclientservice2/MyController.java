package com.sam.springconfigclientservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    // Put http basic security in this mapping
    @GetMapping("/refresh")
    public void refresh() {

        String url = "http://localhost:" + serverSettings.getPort() + "/actuator/refresh";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);

        RestTemplate restTemplate = new RestTemplate();
        Object o = restTemplate.postForObject(url, httpEntity, String.class);
        System.out.println(o);
    }
}
