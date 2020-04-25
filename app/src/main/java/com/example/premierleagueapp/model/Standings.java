package com.example.premierleagueapp.model;

import java.util.ArrayList;

public class Standings {
    private String stage;
    private String type;
    private String group;
    private ArrayList<Table> table;

    public Standings(String stage, String type, String group, ArrayList<Table> table) {
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

    public ArrayList<Table> getTable() {
        return table;
    }
}
