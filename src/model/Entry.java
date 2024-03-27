package model;

import java.time.LocalDateTime;

public class Entry {
    private String id;
    private String author;
    private String body;
    private String title;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public Entry(String id, String author, String body, String title) {
        this.id = id;
        this.author = author;
        this.body = body;
        this.title = title;
    }

    public Entry(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
