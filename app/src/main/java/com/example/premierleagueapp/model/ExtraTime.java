package com.example.premierleagueapp.model;

public class ExtraTime {
    private int homeTeam;
    private int awayTeam;

    public ExtraTime(int homeTeam, int awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

}
