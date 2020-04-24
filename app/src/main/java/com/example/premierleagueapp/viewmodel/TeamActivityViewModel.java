package com.example.premierleagueapp.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.Area;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamsRepository;

public class TeamActivityViewModel extends ViewModel {
    private Team team;
    private TeamsRepository teamsRepository;

    public void init(int position) {
        teamsRepository = TeamsRepository.getInstance();
        team = teamsRepository.getTeam(position);
    }

    public int getId() {
        return team.getId();
    }

    public Area getArea() {
        return team.getArea();
    }

    public String getName() {
        return team.getName();
    }

    public String getShortName() {
        return team.getShortName();
    }

    public String getTla() {
        return team.getTla();
    }

    public String getCrestUrl() {
        return team.getCrestUrl();
    }

    public String getAddress() {
        return team.getAddress();
    }

    public String getPhone() {
        return team.getPhone();
    }

    public String getWebsite() {
        return team.getWebsite();
    }

    public String getEmail() {
        return team.getEmail();
    }

    public int getFounded() {
        return team.getFounded();
    }

    public String getClubColors() {
        return team.getClubColors();
    }

    public String getVenue() {
        return team.getVenue();
    }

    public String getLastUpdated() {
        return team.getLastUpdated();
    }
}
