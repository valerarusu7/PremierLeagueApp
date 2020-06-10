package com.example.premierleagueapp.model;

public class Player {
    private int id;
    private String name;
    private String position;
    private String dateOfBirth;
    private String countryOfBirth;
    private String nationality;
    private int shirtNumber;
    private String role;

    public Player(int id, String name, String position, String dateOfBirth, String countryOfBirth, String nationality, int shirtNumber, String role) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.nationality = nationality;
        this.shirtNumber = shirtNumber;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public String getRole() {
        return role;
    }
}
