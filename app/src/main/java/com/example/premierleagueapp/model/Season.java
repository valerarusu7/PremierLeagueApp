package com.example.premierleagueapp.model;

public class Season {
    public int id;
    public String startDate;
    public String endDate;
    public String currentMatchday;
    public String winner;

    public Season(int id, String startDate, String endDate, String currentMatchday, String winner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentMatchday = currentMatchday;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCurrentMatchday() {
        return currentMatchday;
    }

    public String getWinner() {
        return winner;
    }
}
