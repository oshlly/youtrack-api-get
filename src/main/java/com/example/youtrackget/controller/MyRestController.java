package com.example.youtrackget.controller;

import com.example.youtrackget.models.task.FullTask;
import com.example.youtrackget.models.getTags.Tags;
import com.example.youtrackget.models.addTag.addTagClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyRestController {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${auth.token}")
    private String authToken;

    @Value("${url.post}")
    private String urlPost;

    @Value("${url.get}")
    private String urlGetIssues;

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> authHeader = new HttpEntity<>(headers);

    public String getIssues(String url) {

        headers.set("Authorization", authToken);

        ResponseEntity<List<FullTask>> response = restTemplate.exchange(url,
                HttpMethod.GET,
                authHeader,
                new ParameterizedTypeReference<>() {
                });

        List<FullTask> issues = response.getBody();

        assert issues != null;

        return issues.stream()
                .map(FullTask::toString)
                .collect(Collectors.joining());
    }

    @GetMapping(value = "/all-issues")
    public String getFullIssues() {

        return getIssues(urlGetIssues);
    }

    @GetMapping("/all-issues/sort-by-version")
    public String getSortedIssues(String version) {

        String sorted = urlGetIssues + "&query=version:" + version;

        return getIssues(sorted);
    }

    @Value("${tags.list}")
    private String urlTags;

    @GetMapping("/all-tags")
    public String getTags() {

        headers.set("Authorization", authToken);

        ResponseEntity<List<Tags>> response = restTemplate.exchange(urlTags,
                HttpMethod.GET,
                authHeader,
                new ParameterizedTypeReference<>() {
                });

        List<Tags> tags = response.getBody();

        assert tags != null;

        return tags.stream()
                .map(Tags::toString)
                .collect(Collectors.joining());
    }

    @PostMapping("/add-tag")
    public String setTag(@RequestBody addTagClass addTag) {

        headers.set("Authorization", authToken);

        String urlTagAdd = urlPost + "/" + addTag.getIssueId() + "?fields=tags(id,name)";

        HttpEntity<addTagClass> entity = new HttpEntity<>(addTag, headers);

        restTemplate.exchange(urlTagAdd,
                HttpMethod.POST,
                entity,
                addTagClass.class);

        return "Success";
    }
}

