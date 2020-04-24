package com.example.premierleagueapp.model;

public class Team {
    private int id;
    private Area area;
    private String name;
    private String shortName;
    private String tla;
    private String crestUrl;
    private String address;
    private String phone;
    private String website;
    private String email;
    private int founded;
    private String clubColors;
    private String venue;
    private String lastUpdated;

    public Team(int id, Area area, String name, String shortName, String tla, String crestUrl, String address, String phone, String website, String email, int founded, String clubColors, String venue, String lastUpdated) {
        this.id = id;
        this.area = area;
        this.name = name;
        this.shortName = shortName;
        this.tla = tla;
        this.crestUrl = crestUrl;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.email = email;
        this.founded = founded;
        this.clubColors = clubColors;
        this.venue = venue;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getTla() {
        return tla;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public int getFounded() {
        return founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
