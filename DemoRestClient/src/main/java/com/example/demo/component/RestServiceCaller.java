package com.example.demo.component;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class RestServiceCaller {

    private RestTemplate template;

    public void callAnotherMicroService(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");

        HttpEntity entity = new HttpEntity("", headers);
        ResponseEntity<String> response = template.exchange("http://localhost:8080/employees",
                HttpMethod.GET, entity, String.class );

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        // call post with body
        HttpEntity entityForPost = new HttpEntity("{\"name\":\"Nila\",\"email\":\"nila@nila.com\"," +
                "\"salary\":1000.0,\"dept\":\"eng\"}", headers);
        ResponseEntity<String> responseFromPost = template.exchange("http://localhost:8080/employee",
                HttpMethod.POST, entityForPost, String.class );

        System.out.println(responseFromPost.getStatusCode());
        System.out.println(responseFromPost.getBody());

        // call get again
        response = template.exchange("http://localhost:8080/employees",
                HttpMethod.GET, entity, String.class );

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

    }

    @PostConstruct
    public void setup(){
        template = new RestTemplate();
    }
}
