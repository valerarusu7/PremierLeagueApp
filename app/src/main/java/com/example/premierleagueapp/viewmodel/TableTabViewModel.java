package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.repositories.TableRepository;

import java.util.ArrayList;

public class TableTabViewModel extends AndroidViewModel {
    private TableRepository tableRepository;

    public TableTabViewModel(@NonNull Application application) {
        super(application);
        tableRepository = TableRepository.getInstance(application);
    }

    public LiveData<ArrayList<Table>> getStandings() {
        return tableRepository.getStandingsData();
    }

}
