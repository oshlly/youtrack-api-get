package com.example.youtrackget.models.getTags;

import java.util.List;

public class Tags {

    private List<Issue> issues = null;
    private String name;
    private String id;
    private String $type;

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    @Override
    public String toString() {
        return "Tag: " + name
                + "\nid: " + id
                + "\nissues that contain this tag: " + issues.stream().toList() + "\n\n";
    }
}
