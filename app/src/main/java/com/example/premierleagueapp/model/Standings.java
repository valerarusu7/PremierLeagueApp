package com.example.premierleagueapp.model;

public class Standings {
    private String stage;
    private String type;
    private String group;
    private Table table;

    public Standings(String stage, String type, String group, Table table) {
        this.stage = stage;
        this.type = type;
        this.group = group;
        this.table = table;
    }

    public String getStage() {
        return stage;
    }

    public String getType() {
        return type;
    }

    public String getGroup() {
        return group;
    }

    public Table getTable() {
        return table;
    }
}
