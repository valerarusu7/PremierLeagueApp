package com.example.premierleagueapp.repositories;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.CompetitionStandings;
import com.example.premierleagueapp.model.Standings;
import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.requests.TableEndpoints;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TableRepository {

    private static TableRepository instance;
    private ArrayList<Table> standingsDataSet = new ArrayList<>();
    private static final String TOKEN = "f3a2512d06ae44e68a95be8689245c1f";

    public static TableRepository getInstance() {
        if (instance == null) {
            instance = new TableRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Table>> getStandingsData() {
        setTable();

        MutableLiveData<ArrayList<Table>> data = new MutableLiveData<>();
        data.setValue(standingsDataSet);
        return data;
    }

    public void setTable() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.football-data.org/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        TableEndpoints endpoints = retrofit.create(TableEndpoints.class);

        Call<CompetitionStandings> call = endpoints.getTable(TOKEN);
        call.enqueue(new Callback<CompetitionStandings>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<CompetitionStandings> call, Response<CompetitionStandings> response) {
                CompetitionStandings apiStandings = response.body();
                for(int i = 0; i < apiStandings.getStandings().size(); i++) {
                    standingsDataSet.addAll(i, apiStandings.getStandings().get(i).getTable());
                }
            }

            @Override
            public void onFailure(Call<CompetitionStandings> call, Throwable t) {
                System.out.println("Failed to load the data from  : TABLE");
                System.out.println(t.getMessage());

            }
        });

    }

}
