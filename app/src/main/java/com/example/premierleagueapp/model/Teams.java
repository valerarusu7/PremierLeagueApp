package com.example.premierleagueapp.model;

import java.util.ArrayList;

public class Teams {
    private int count;
    private Filters filters;
    private Competition competition;
    private Season season;
    private ArrayList<Team> teams;

    public Teams(int count, Filters filters, Competition competition, Season season, ArrayList<Team> teams) {
        this.count = count;
        this.filters = filters;
        this.competition = competition;
        this.season = season;
        this.teams = teams;
    }

    public int getCount() {
        return count;
    }

    public Filters getFilters() {
        return filters;
    }

    public Competition getCompetition() {
        return competition;
    }

    public Season getSeason() {
        return season;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }
}
