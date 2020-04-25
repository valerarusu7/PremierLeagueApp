package com.example.premierleagueapp.model;

import java.util.ArrayList;

public class Match {
    private int id;
    private Season season;
    private String utcDate;
    private String status;
    private int matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private Odds odds;
    private Score score;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;
    private ArrayList<Referee> referees;

    public Match(int id, Season season, String utcDate, String status, int matchday, String stage, String group, String lastUpdated, Odds odds, Score score, HomeTeam homeTeam, AwayTeam awayTeam, ArrayList<Referee> referees) {
        this.id = id;
        this.season = season;
        this.utcDate = utcDate;
        this.status = status;
        this.matchday = matchday;
        this.stage = stage;
        this.group = group;
        this.lastUpdated = lastUpdated;
        this.odds = odds;
        this.score = score;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.referees = referees;
    }

    public int getId() {
        return id;
    }

    public Season getSeason() {
        return season;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public String getStatus() {
        return status;
    }

    public int getMatchday() {
        return matchday;
    }

    public String getStage() {
        return stage;
    }

    public String getGroup() {
        return group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Odds getOdds() {
        return odds;
    }

    public Score getScore() {
        return score;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public ArrayList<Referee> getReferees() {
        return referees;
    }
}
