package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamsRepository;

import java.util.ArrayList;

public class FavoriteTeamActivityViewModel extends AndroidViewModel {
    private TeamsRepository teamsRepository;

    public FavoriteTeamActivityViewModel(@NonNull Application application) {
        super(application);
        teamsRepository = TeamsRepository.getInstance(application);
    }


    public LiveData<ArrayList<Team>> getTeams() {
        return teamsRepository.getTeams();
    }

    public void updateTeam(Team team) {
        teamsRepository.update(team);
    }

    public LiveData<Team> getFavoriteTeam() {
        return teamsRepository.getFavoriteTeam();
    }
}
