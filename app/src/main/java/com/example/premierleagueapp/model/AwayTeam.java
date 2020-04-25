package com.example.premierleagueapp.model;

public class AwayTeam {
    private int id;
    private String name;

    public AwayTeam(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
