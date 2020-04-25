package com.example.premierleagueapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.repositories.FixturesRepository;
import com.example.premierleagueapp.requests.FixturesEndpoints;

import java.util.ArrayList;

public class FixturesTabViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Match>> matchList;
    private FixturesRepository fixturesRepository;

    public void init() {
        if(matchList != null) {
            return;
        }
        fixturesRepository = FixturesRepository.getInstance();
        matchList = fixturesRepository.getFixturesData();
    }

    public LiveData<ArrayList<Match>> getMatches() {
        return matchList;
    }

}
