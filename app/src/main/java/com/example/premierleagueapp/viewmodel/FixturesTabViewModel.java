package com.example.premierleagueapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.FixturesByMatchday;
import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.repositories.FixturesRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class FixturesTabViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Match>> matchList;
    private MutableLiveData<ArrayList<Integer>> matchdays;
    private FixturesRepository fixturesRepository;

    public void init() {
        if(matchList != null) {
            return;
        }
        fixturesRepository = FixturesRepository.getInstance();
        matchList = fixturesRepository.getFixturesData();
        matchdays = fixturesRepository.getMatchDays();
    }

    public LiveData<ArrayList<Match>> getMatches() {
        return matchList;
    }

    public LiveData<ArrayList<Integer>> getMachdays() {
        return matchdays;
    }

}
