package com.example.premierleagueapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.requests.clients.TeamDetailsAPIClient;

public class TeamDetailsRepository {
    private static TeamDetailsRepository instance;
    private TeamDetailsAPIClient teamDetailsAPIClient;

    private TeamDetailsRepository(Application application) {
        teamDetailsAPIClient = new TeamDetailsAPIClient(application);
    }

    public static TeamDetailsRepository getInstance(Application application) {
        if (instance == null) {
            instance = new TeamDetailsRepository(application);
        }
        return instance;
    }

    public LiveData<Team> getTeamByIdData(int id) {
        return teamDetailsAPIClient.getTeamByIdLiveData(id);
    }

}
