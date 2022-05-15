package com.example.youtrackget.client;

import com.example.youtrackget.model.Id;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    private static void callRestService() {

        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer perm:QnVsYW5vdg==.NTAtMQ==.mGcpHZdhNyKMMtcAKvChfV5QHhMBpL");

        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Id> id = restTemplate.exchange("https://oshlly09.youtrack.cloud/api/admin/users/me", HttpMethod.GET, entity, Id.class);
        System.out.println(id.getBody().getId() + " " + id.getBody().get$type());
    }

    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
