package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.repositories.FixturesRepository;

import java.util.ArrayList;

public class FixturesTabViewModel extends AndroidViewModel {
    private FixturesRepository fixturesRepository;

    public FixturesTabViewModel(@NonNull Application application) {
        super(application);
        fixturesRepository = FixturesRepository.getInstance(application);
    }

    public LiveData<ArrayList<Match>> getMatches() {
        return fixturesRepository.getFixturesData();
    }

    public LiveData<Boolean> getIsLoading() {
        return fixturesRepository.getIsLoading();
    }

}
