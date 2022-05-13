package com.example.youtrackget.client;

import com.example.youtrackget.model.Id;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    private static void callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        Id id = restTemplate.getForObject("https://example.youtrack.cloud/api/admin/users/me", Id.class);
        System.out.println(id.getId() + " " + id.get$type());
    }

    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
