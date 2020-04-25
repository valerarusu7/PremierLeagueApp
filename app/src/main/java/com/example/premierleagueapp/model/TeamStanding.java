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
}
