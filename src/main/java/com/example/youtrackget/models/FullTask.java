package com.example.youtrackget.models;

import java.util.List;

public class FullTask {

    private String description;
    private List<Comment> comments = null;
    private String summary;
    private List<Attachment> attachments = null;
    private String id;
    private String $type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setGetComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setGetAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
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
        return "\nSummary: " + summary
                + "\ndescription: " + description
                + "\nid: " + id
                + "\ncomments: " + comments.stream().toList()
                + "\nattachments: " + attachments.stream().toList() + "\n";
    }
}
