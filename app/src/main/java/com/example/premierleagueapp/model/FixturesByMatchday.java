package com.example.premierleagueapp.model;

import java.util.ArrayList;
import java.util.HashMap;

public class FixturesByMatchday {
    private HashMap<Integer, ArrayList<Match>> matches;

    public FixturesByMatchday(HashMap<Integer, ArrayList<Match>> matches) {
        this.matches = matches;
    }

    public ArrayList<Match> getMatchesByMatchday(ArrayList<Match> apiMatches, int matchday) {
        ArrayList<Match> matchesByMatchday = new ArrayList<>();
        for (int i = 0; i < apiMatches.size(); i++) {
            if (matchday == apiMatches.get(i).getMatchday()) {
                matchesByMatchday.add(apiMatches.get(i));
            }
        }
        return matchesByMatchday;
    }

    public ArrayList<Match> getMatchesByMatchday(int matchday) {
        return matches.get(matchday);
    }

    public HashMap<Integer, ArrayList<Match>> getMatches() {
        return matches;
    }
}
