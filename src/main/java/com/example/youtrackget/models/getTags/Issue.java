package com.example.youtrackget.models.getTags;

public class Issue {

    private String summary;
    private String $type;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    @Override
    public String toString() {
        return "name:" + summary;
    }
}
