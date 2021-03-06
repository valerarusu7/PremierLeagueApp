package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamDetailsRepository;

public class TeamActivityViewModel extends AndroidViewModel {
    private TeamDetailsRepository teamDetailsRepository;

    public TeamActivityViewModel(Application application) {
        super(application);
        this.teamDetailsRepository = TeamDetailsRepository.getInstance(application);
    }

    public LiveData<Team> getTeam(int id) {
        return teamDetailsRepository.getTeamByIdData(id);
    }

}
