package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.FixturesByMatchday;
import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.repositories.FixturesRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class FixturesTabViewModel extends AndroidViewModel {
    private FixturesRepository fixturesRepository;

    public FixturesTabViewModel(@NonNull Application application) {
        super(application);
        fixturesRepository = FixturesRepository.getInstance(application);
    }

    public LiveData<ArrayList<Match>> getMatches() {
        return fixturesRepository.getFixturesData();
    }

}
