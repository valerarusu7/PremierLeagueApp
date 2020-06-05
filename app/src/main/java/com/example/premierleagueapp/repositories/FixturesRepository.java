package com.example.premierleagueapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.requests.clients.FixturesAPIClient;

import java.util.ArrayList;

public class FixturesRepository {
    private static FixturesRepository instance;
    private Application application;
    private FixturesAPIClient fixturesAPIClient;

    public FixturesRepository(Application application) {
        this.application = application;
        fixturesAPIClient = new FixturesAPIClient(application);
    }

    public static FixturesRepository getInstance(Application application) {
        if (instance == null) {
            instance = new FixturesRepository(application);
        }
        return instance;
    }

    public LiveData<ArrayList<Match>> getFixturesData() {
        return fixturesAPIClient.getFixturesLiveData();
    }
}
