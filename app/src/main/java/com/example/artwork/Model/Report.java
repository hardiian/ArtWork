package com.example.artwork.Model;

public class Report {

    private String id;
    private String username;
    private String fullname;
    private String postImage;
    private String report;
    private String time;

    public Report(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPostImage() { return postImage; }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
