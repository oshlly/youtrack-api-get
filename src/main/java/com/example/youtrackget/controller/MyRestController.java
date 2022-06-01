package com.example.youtrackget.controller;

import com.example.youtrackget.models.FullTask;
import com.example.youtrackget.models.Tags;
import com.example.youtrackget.models.addTag.Id;
import com.example.youtrackget.models.addTag.addTagClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyRestController {

    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    RestTemplate restTemplate = new RestTemplate();

    @Value("${auth.token}")
    private String authToken;

    @Value("${url.get}")
    private String urlGetIssues;

    @Value("${url.post}")
    private String urlPost;

    HttpHeaders headers = new HttpHeaders();
    final HttpEntity<String> authHeader = new HttpEntity<>(headers);

    @GetMapping(value = "/all-issues")
    public void getFullIssues() {

        headers.set("Authorization", authToken);

        ResponseEntity<List<FullTask>> response = restTemplate.exchange(urlGetIssues,
                HttpMethod.GET,
                authHeader,
                new ParameterizedTypeReference<>() {
                });

        List<FullTask> issues = response.getBody();

        assert issues != null;

        System.out.println(issues.stream()
                .map(FullTask::toString)
                .collect(Collectors.joining()));

        System.out.println("\nSuccess");
    }

    @Value("${tags.list}")
    private String urlTags;

    @GetMapping("/all-tags")
    public void getTags() {

        headers.set("Authorization", authToken);

        ResponseEntity<List<Tags>> response = restTemplate.exchange(urlTags,
                HttpMethod.GET,
                authHeader,
                new ParameterizedTypeReference<>() {
                });

        List<Tags> tags = response.getBody();

        assert tags != null;

        System.out.println(tags.stream()
                .map(Tags::toString)
                .collect(Collectors.joining()));

        System.out.println("\nSuccess");
    }

    @PostMapping("/add-tag")
    public void setTag() throws IOException {

        headers.set("Authorization", authToken);

        System.out.println("\nEnter issue Id: ");
        String writeIssueId = bufferedReader.readLine();

        String urlTagAdd = urlPost + "/" + writeIssueId + "?fields=tags(id,name)";

        System.out.println("\nEnter tag Id: ");
        String writeTagId = bufferedReader.readLine();

        addTagClass addTags = new addTagClass();

        List<Id> tags = new ArrayList<>();
        Id tag = new Id();
        tag.setId(writeTagId);
        tags.add(0, tag);

        addTags.setTags(tags);

        HttpEntity<addTagClass> entity = new HttpEntity<>(addTags, headers);

        restTemplate.exchange(urlTagAdd,
                HttpMethod.POST,
                entity,
                addTagClass.class);

        System.out.println("\nSuccess");
    }

//    @DeleteMapping("/delete-specific-tag")
//    public void deleteSpecificTag() throws IOException {

//        headers.set("Authorization", authToken);

//        System.out.println("\nEnter issue Id: ");
//        String writeIssueId = bufferedReader.readLine();

//        System.out.println("\nEnter tag Id: ");
//        String writeTagId = bufferedReader.readLine();

//        String urlTagDelete = urlPost + "/" + writeIssueId + "/tags/" + writeTagId;
//        System.out.println(urlTagDelete);

//        restTemplate.exchange(urlTagDelete, HttpMethod.DELETE, authHeader, String.class);

//        System.out.println("Success");
//    }
//}

// {
//    "error": "Not Found",
//    "error_description": "Entity with id 6-2 not found" ?
//}

}

