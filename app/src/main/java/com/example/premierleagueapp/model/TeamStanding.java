package com.example.premierleagueapp.model;

public class TeamStanding {
    private int id;
    private String name;
    private String crestUrl;

    public TeamStanding(int id, String name, String crestUrl) {
        this.id = id;
        this.name = name;
        this.crestUrl = crestUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }
}
