package com.example.premierleagueapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.requests.clients.TableAPIClient;

import java.util.ArrayList;

public class TableRepository {
    private static TableRepository instance;
    private TableAPIClient tableAPIClient;

    public TableRepository(Application application) {
        tableAPIClient = new TableAPIClient(application);
    }

    public static TableRepository getInstance(Application application) {
        if (instance == null) {
            instance = new TableRepository(application);
        }
        return instance;
    }

    public LiveData<ArrayList<Table>> getStandingsData() {
        return tableAPIClient.getTableLiveData();
    }
}
