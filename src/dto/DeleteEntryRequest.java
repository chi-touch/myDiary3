package dto;

public class DeleteEntryRequest {
    private String id;
    private String author;

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
}
