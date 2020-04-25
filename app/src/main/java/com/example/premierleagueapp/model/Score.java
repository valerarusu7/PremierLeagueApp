package com.example.premierleagueapp.model;

public class Score {
    private String winner;
    private String duration;
    private FullTime fullTime;
    private HalfTime halfTime;
    private ExtraTime extraTime;
    private Penalties penalties;

    public Score(String winner, String duration, FullTime fullTime, HalfTime halfTime, ExtraTime extraTime, Penalties penalties) {
        this.winner = winner;
        this.duration = duration;
        this.fullTime = fullTime;
        this.halfTime = halfTime;
        this.extraTime = extraTime;
        this.penalties = penalties;
    }

    public String getWinner() {
        return winner;
    }

    public String getDuration() {
        return duration;
    }

    public FullTime getFullTime() {
        return fullTime;
    }

    public HalfTime getHalfTime() {
        return halfTime;
    }

    public ExtraTime getExtraTime() {
        return extraTime;
    }

    public Penalties getPenalties() {
        return penalties;
    }
}
