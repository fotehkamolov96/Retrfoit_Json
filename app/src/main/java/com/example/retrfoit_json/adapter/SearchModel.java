package com.example.retrfoit_json.adapter;

public class SearchModel {
    private int id;
    private String nametitle;
    private String description;

    public int getId() {
        return id;
    }

    public SearchModel(int id, String nametitle, String description) {
        this.id = id;
        this.nametitle = nametitle;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNametitle() {
        return nametitle;
    }

    public void setNametitle(String nametitle) {
        this.nametitle = nametitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
