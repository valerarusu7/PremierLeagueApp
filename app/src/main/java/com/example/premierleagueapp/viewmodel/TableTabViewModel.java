package com.example.premierleagueapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.repositories.TableRepository;

import java.util.ArrayList;

public class TableTabViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Table>> standingList;
    private TableRepository tableRepository;

    public void init() {
        if(standingList != null) {
            return;
        }
        tableRepository = TableRepository.getInstance();
        standingList = tableRepository.getStandingsData();
    }

    public LiveData<ArrayList<Table>> getStandings() {
        return standingList;
    }

}
