package com.example.premierleagueapp.repositories;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.AwayTeam;
import com.example.premierleagueapp.model.FixturesByMatchday;
import com.example.premierleagueapp.model.FullTime;
import com.example.premierleagueapp.model.HomeTeam;
import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.model.Matches;
import com.example.premierleagueapp.model.Score;
import com.example.premierleagueapp.requests.FixturesEndpoints;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FixturesRepository {
    private static FixturesRepository instance;
    private ArrayList<Match> fixturesDataSet = new ArrayList<>();
    private ArrayList<Integer> matchdaysDataSet = new ArrayList<>();
    private static final String TOKEN = "f3a2512d06ae44e68a95be8689245c1f";

    public static FixturesRepository getInstance() {
        if (instance == null) {
            instance = new FixturesRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Match>> getFixturesData() {
        setFixtures();

        MutableLiveData<ArrayList<Match>> data = new MutableLiveData<>();
        data.setValue(fixturesDataSet);
        return data;
    }

    public void setFixtures() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        FixturesEndpoints endpoints = retrofit.create(FixturesEndpoints.class);

        Call<Matches> call = endpoints.getFixtures(TOKEN);
        call.enqueue(new Callback<Matches>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Matches> call, Response<Matches> response) {
                Matches apiMatches = response.body();
                if(response.isSuccessful() && apiMatches != null) {
                    for(int i = 1; i < apiMatches.getMatches().size(); i++) {
                        if(apiMatches.getMatches().get(i).getMatchday() == i) {
                            fixturesDataSet.addAll(apiMatches.getMatches());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Matches> call, Throwable t) {
                System.out.println("Failed to load the data from api : FIXTURES");

            }
        });

    }


    public MutableLiveData<ArrayList<Integer>> getMatchDays() {
        for(int i = 0; i < 38; i++) {
            matchdaysDataSet.add(i+1);
        }
        MutableLiveData<ArrayList<Integer>> data = new MutableLiveData<>();
        data.setValue(matchdaysDataSet);
        return data;
    }
}
