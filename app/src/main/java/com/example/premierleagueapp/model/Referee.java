package com.example.premierleagueapp.model;

public class Referee {
    private int id;
    private String name;
    private String nationality;

    public Referee(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
