package com.example.premierleagueapp.model;

public class Competition {
    public int id;
    public Area area;
    public String name;
    public String code;
    public String plan;
    public String lastUpdated;

    public Competition(int id, Area area, String name, String code, String plan, String lastUpdated) {
        this.id = id;
        this.area = area;
        this.name = name;
        this.code = code;
        this.plan = plan;
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

    public String getCode() {
        return code;
    }

    public String getPlan() {
        return plan;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
