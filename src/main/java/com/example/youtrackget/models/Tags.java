package com.example.youtrackget.models;

public class Tags {

    private String name;
    private String id;
    private String $type;

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
        return "\nTag name: " + name + "\nid: " + id + "\n";
    }
}
