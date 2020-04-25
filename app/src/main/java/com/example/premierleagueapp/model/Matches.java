package com.example.premierleagueapp.model;

import java.util.ArrayList;

public class Matches {
    private int count;
    private Filters filters;
    private Competition competition;
    private ArrayList<Match> matches;

    public Matches(int count, Filters filters, Competition competition, ArrayList<Match> matches) {
        this.count = count;
        this.filters = filters;
        this.competition = competition;
        this.matches = matches;
    }

    public int getCount() {
        return count;
    }

    public Filters getFilters() {
        return filters;
    }

    public Competition getCompetition() {
        return competition;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }
}
