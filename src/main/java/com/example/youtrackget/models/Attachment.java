package com.example.youtrackget.models;

public class Attachment {

    private String url;
    private String $type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    @Override
    public String toString() {
        return "attachment-url: " + url;
    }

}
