package com.example.artwork.Model;

public class Post {

    private String postid;
    private String postImage;
    private String description;
    private String publisher;
    String report;

    public void postreport(String report){
        this.report = report;
    }
    public Post(String postid, String postImage, String description, String publisher) {
        this.postid = postid;
        this.postImage = postImage;
        this.description = description;
        this.publisher = publisher;
    }



    public Post() {
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) { this.publisher = publisher;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }


}
