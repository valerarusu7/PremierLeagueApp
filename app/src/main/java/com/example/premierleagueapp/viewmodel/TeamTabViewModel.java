package com.example.premierleagueapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamsRepository;

import java.util.ArrayList;

public class TeamTabViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Team>> teamsList;
    private TeamsRepository teamsRepository;

    public void init() {
        if(teamsList != null) {
            return;
        }
        teamsRepository = TeamsRepository.getInstance();
        teamsList = teamsRepository.getTeamsData();
    }

    public LiveData<ArrayList<Team>> getTeams() {
        return teamsList;
    }



}
