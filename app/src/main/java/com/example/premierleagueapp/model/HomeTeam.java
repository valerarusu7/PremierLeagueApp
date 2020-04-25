package com.example.premierleagueapp.model;

public class HomeTeam {
    private int id;
    private String name;

    public HomeTeam(int id, String name) {
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
