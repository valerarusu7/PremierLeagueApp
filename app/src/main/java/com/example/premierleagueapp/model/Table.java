package com.example.premierleagueapp.model;

public class Table {
    private int position;
    private TeamStanding team;
    private int playedGames;
    private int won;
    private int draw;
    private int lost;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;

    public Table(int position, TeamStanding team, int playedGames, int won, int draw, int lost, int points, int goalsFor, int goalsAgainst, int goalDifference) {
        this.position = position;
        this.team = team;
        this.playedGames = playedGames;
        this.won = won;
        this.draw = draw;
        this.lost = lost;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
    }

    public int getPosition() {
        return position;
    }

    public TeamStanding getTeam() {
        return team;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getWon() {
        return won;
    }

    public int getDraw() {
        return draw;
    }

    public int getLost() {
        return lost;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }
}
