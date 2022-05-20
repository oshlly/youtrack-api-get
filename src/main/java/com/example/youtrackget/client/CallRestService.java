package com.example.youtrackget.client;

import com.example.youtrackget.model.MyTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CallRestService implements CommandLineRunner {

    private static void callRestService() {

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer perm:QnVsYW5vdg==.NTAtMQ==.mGcpHZdhNyKMMtcAKvChfV5QHhMBpL");

        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        //GET Info

        RestTemplate restTemplate = new RestTemplate();
        String myUrlGet = "https://oshlly09.youtrack.cloud/api/issues?fields=id,summary,description,comments(id,text,author(name)),attachments(url)";
        ResponseEntity<List<MyTask>> response = restTemplate.exchange(myUrlGet, HttpMethod.GET, entity, new ParameterizedTypeReference<List<MyTask>>() {});
        List<MyTask> summaryDescriptions = response.getBody();

        for (int i = 0; i < summaryDescriptions.size(); i++) {
            System.out.println("    ");
            System.out.println("Task name: " + summaryDescriptions.get(i).getSummary());
            System.out.println("Task description: " + summaryDescriptions.get(i).getDescription());
            for (int j = 0; j < summaryDescriptions.get(i).getCommentsSize(); j++) {
                System.out.println("Task Comment Author: " + summaryDescriptions.get(i).getComments().get(j).getAuthor().getName());
                System.out.println("Task Comment Text: " + summaryDescriptions.get(i).getComments().get(j).getText());
            }
            for (int n = 0; n < summaryDescriptions.get(i).getAttachmentsSize(); n++) {
                System.out.println("Task Attachments: " + summaryDescriptions.get(i).getAttachments().get(n).getUrl());
            }
        }

        //POST info

        Map newMapReq = new HashMap();
        newMapReq.put("summary", "Мое название для задачи 1");
        HttpEntity<Map<String, Object>> entityPost = new HttpEntity<>(newMapReq, headers);

        String myUrlPost = "https://oshlly09.youtrack.cloud/api/admin/projects/0-0/issues/2-23?fields=summary";
        restTemplate.postForEntity(myUrlPost, entityPost, String.class);

    }

    @Override
    public void run(String... args) {
        callRestService();
    }
}
