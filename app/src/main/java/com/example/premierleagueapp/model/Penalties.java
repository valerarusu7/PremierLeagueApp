package com.example.premierleagueapp.model;

public class Penalties {
    private int homeTeam;
    private int awayTeam;

    public Penalties(int homeTeam, int awayTeam) {
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
