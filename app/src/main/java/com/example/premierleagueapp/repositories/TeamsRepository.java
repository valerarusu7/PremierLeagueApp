package com.example.premierleagueapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.requests.clients.TeamsAPIClient;

import java.util.ArrayList;

public class TeamsRepository {
    private static TeamsRepository instance;
    private TeamsAPIClient teamsAPIClient;
    private Application application;

    public TeamsRepository(Application application) {
        this.application = application;
        teamsAPIClient = new TeamsAPIClient(application);
    }

    public static TeamsRepository getInstance(Application application) {
        if (instance == null) {
            instance = new TeamsRepository(application);
        }
        return instance;
    }

    public LiveData<ArrayList<Team>> getTeamsData() {
        return teamsAPIClient.getTeamsLiveData();
    }
}
