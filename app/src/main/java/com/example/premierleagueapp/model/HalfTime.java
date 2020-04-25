package com.example.premierleagueapp.model;

public class HalfTime {
    private int homeTeam;
    private int awayTeam;

    public HalfTime(int homeTeam, int awayTeam) {
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
