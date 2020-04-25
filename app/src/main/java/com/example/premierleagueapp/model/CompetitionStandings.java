package com.example.premierleagueapp.model;

public class CompetitionStandings {
    private Filters filters;
    private Competition competition;
    private Season season;
    private Standings standings;

    public CompetitionStandings(Filters filters, Competition competition, Season season, Standings standings) {
        this.filters = filters;
        this.competition = competition;
        this.season = season;
        this.standings = standings;
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

    public Standings getStandings() {
        return standings;
    }
}
