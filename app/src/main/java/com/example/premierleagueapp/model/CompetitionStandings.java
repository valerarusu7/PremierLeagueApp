package com.example.premierleagueapp.model;

import java.util.ArrayList;

public class CompetitionStandings {
    private Filters filters;
    private Competition competition;
    private Season season;
    private ArrayList<Standings> standings;

    public CompetitionStandings(Filters filters, Competition competition, Season season, ArrayList<Standings> standings) {
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

    public ArrayList<Standings> getStandings() {
        return standings;
    }
}
