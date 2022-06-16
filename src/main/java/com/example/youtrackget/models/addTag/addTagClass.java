package com.example.youtrackget.models.addTag;

import java.util.List;

public class addTagClass {

    private List<Id> tags = null;
    private String issueId;

    public List<Id> getTags() {
        return tags;
    }

    public void setTags(List<Id> tags) {
        this.tags = tags;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssueId() {
        return issueId;
    }
}
