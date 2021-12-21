package com.example.retrfoit_json.Model;

public class Movie {
    private String namepd;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imagepd;
    private String bio;

    public Movie() {
    }

    public Movie(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.namepd = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imagepd = imageurl;
        this.bio = bio;
    }

    public String getNamepd() {
        return namepd;
    }

    public void setNamepd(String namepd) {
        this.namepd = namepd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImagepd() {
        return imagepd;
    }

    public void setImagepd(String imagepd) {
        this.imagepd = imagepd;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
