package com.example.premierleagueapp.requests.clients;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.Player;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.requests.ServiceGenerator;
import com.example.premierleagueapp.requests.TeamEndpoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailsAPIClient {
    private Application application;
    private MutableLiveData<Team> teamLiveData = new MutableLiveData<>();
    private ArrayList<Player> squad = new ArrayList<>();

    public TeamDetailsAPIClient(Application application) {
        this.application = application;
        squad = new ArrayList<>();
    }


    public LiveData<Team> getTeamByIdLiveData(int id) {
        TeamEndpoints endpoints = ServiceGenerator.getTeamEndpoints();
        squad = new ArrayList<>();

        Call<Team> call = endpoints.getTeamById(id, Token.getTOKEN());
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(@NonNull Call<Team> call, @NonNull Response<Team> response) {
                System.out.println("SUCCESSFUL LOAD OF : TEAM " + response.body());
                Team apiTeam = response.body();
                if (response.isSuccessful() && apiTeam != null) {
                    squad.addAll(apiTeam.getSquad());
                    teamLiveData.setValue(apiTeam);
                    teamLiveData.getValue().setSquad(squad);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Team> call, @NonNull Throwable t) {
                System.out.println("Failed to load the data from api : TEAMS");

            }
        });
        return teamLiveData;
    }

}
