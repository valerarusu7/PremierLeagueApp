package com.example.premierleagueapp.requests.clients;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.model.Teams;
import com.example.premierleagueapp.requests.ServiceGenerator;
import com.example.premierleagueapp.requests.TeamsEndpoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsAPIClient {
    private MutableLiveData<ArrayList<Team>> teamsLiveData = new MutableLiveData<>();
    private Application application;

    public TeamsAPIClient(Application application) {
        this.application = application;
    }


    public LiveData<ArrayList<Team>> getTeamsLiveData() {
        TeamsEndpoints endpoints = ServiceGenerator.getTeamsEndpoints();
        Call<Teams> call = endpoints.getTeams(Token.getTOKEN());
        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                System.out.println("RESPONSE BODY FOR TEAMS: " + response.body());
                Teams apiTeams = response.body();
                if (response.isSuccessful() && apiTeams != null) {
                    teamsLiveData.setValue(apiTeams.getTeams());
                }
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
                System.out.println("Failed to load the data from api : TEAMS");

            }
        });
        return teamsLiveData;
    }
}
