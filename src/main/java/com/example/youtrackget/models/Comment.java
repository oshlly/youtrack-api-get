package com.example.youtrackget.models;

public class Comment {

    private Author author;
    private String text;
    private String id;
    private String $type;

    public Author getAuthor() {
        return author;
    }

    public void setGetAuthor(Author author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        return "author: " + author.getName()
                + " text: " + text
                + " id: " + id;
    }

}
