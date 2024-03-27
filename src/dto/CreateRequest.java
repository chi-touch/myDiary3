package dto;

import java.time.LocalDateTime;

public class CreateRequest {
    private String title;

    private String body;
    private String author;

    public CreateRequest(String title, String body, String author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private LocalDateTime createdDate;

    public CreateRequest(){}
}
