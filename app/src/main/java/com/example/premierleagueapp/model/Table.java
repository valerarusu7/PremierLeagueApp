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

    public void setPosition(int position) {
        this.position = position;
    }

    public void setTeam(TeamStanding team) {
        this.team = team;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }
}
