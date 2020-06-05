package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamsRepository;

import java.util.ArrayList;

public class TeamTabViewModel extends AndroidViewModel {
    private TeamsRepository teamsRepository;

    public TeamTabViewModel(@NonNull Application application) {
        super(application);
        teamsRepository = TeamsRepository.getInstance(application);
    }

    public LiveData<ArrayList<Team>> getTeams() {
        return teamsRepository.getTeamsData();
    }
}
