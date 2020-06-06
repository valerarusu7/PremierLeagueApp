package com.example.premierleagueapp.requests.clients;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.model.Matches;
import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.requests.FixturesEndpoints;
import com.example.premierleagueapp.requests.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FixturesAPIClient {
    private MutableLiveData<ArrayList<Match>> fixturesLiveData = new MutableLiveData<>();
    private Application application;

    public FixturesAPIClient(Application application) {
        this.application = application;
    }

    public LiveData<ArrayList<Match>> getFixturesLiveData() {
        FixturesEndpoints endpoints = ServiceGenerator.getFixturesEndpoints();

        Call<Matches> call = endpoints.getFixtures(Token.getTOKEN());
        call.enqueue(new Callback<Matches>() {
            @Override
            public void onResponse(Call<Matches> call, Response<Matches> response) {
                Matches apiMatches = response.body();
                if (response.isSuccessful() && apiMatches != null) {
                    fixturesLiveData.setValue(apiMatches.getMatches());
                }
            }

            @Override
            public void onFailure(Call<Matches> call, Throwable t) {
                System.out.println("Failed to load the data from api : FIXTURES");

            }
        });
        return fixturesLiveData;
    }
}
