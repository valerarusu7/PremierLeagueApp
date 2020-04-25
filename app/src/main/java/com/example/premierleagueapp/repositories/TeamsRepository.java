package com.example.premierleagueapp.repositories;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.model.Teams;
import com.example.premierleagueapp.requests.TeamsEndpoints;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamsRepository {
    private static TeamsRepository instance;
    private ArrayList<Team> teamsDataSet = new ArrayList<>();
    private static final String TOKEN = "f3a2512d06ae44e68a95be8689245c1f";

    public static TeamsRepository getInstance() {
        if (instance == null) {
            instance = new TeamsRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Team>> getTeamsData() {
        setTeams();

        MutableLiveData<ArrayList<Team>> data = new MutableLiveData<>();
        data.setValue(teamsDataSet);
        return data;
    }

    private void setTeams() {
                Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        TeamsEndpoints endpoints = retrofit.create(TeamsEndpoints.class);

        Call<Teams> call = endpoints.getTeams(TOKEN);
        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                Teams apiTeams = response.body();
                if(response.isSuccessful() && apiTeams != null) {
                    teamsDataSet.addAll(apiTeams.getTeams());
                }
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
                System.out.println("Failed to load the data from api : TEAMS");

            }
        });
    }

    public Team getTeam(int position) {
        return teamsDataSet.get(position);
    }
}
