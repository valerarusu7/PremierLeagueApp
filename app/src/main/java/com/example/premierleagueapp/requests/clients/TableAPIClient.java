package com.example.premierleagueapp.requests.clients;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.CompetitionStandings;
import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.requests.ServiceGenerator;
import com.example.premierleagueapp.requests.TableEndpoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableAPIClient {
    private MutableLiveData<ArrayList<Table>> standingsLiveData = new MutableLiveData<>();
    private ArrayList<Table> tableArrayList = new ArrayList<>();
    private Application application;

    public TableAPIClient(Application application) {
        this.application = application;
    }


    public LiveData<ArrayList<Table>> getTableLiveData() {
        TableEndpoints endpoints = ServiceGenerator.getTableEndpoints();

        Call<CompetitionStandings> call = endpoints.getTable(Token.getTOKEN());
        call.enqueue(new Callback<CompetitionStandings>() {
            @Override
            public void onResponse(Call<CompetitionStandings> call, Response<CompetitionStandings> response) {
                CompetitionStandings apiStandings = response.body();
                for (int i = 0; i < apiStandings.getStandings().size(); i++) {
                    tableArrayList.addAll(i, apiStandings.getStandings().get(i).getTable());
                }
                standingsLiveData.setValue(tableArrayList);
            }

            @Override
            public void onFailure(Call<CompetitionStandings> call, Throwable t) {
                System.out.println("Failed to load the data from  : TABLE");
                System.out.println(t.getMessage());

            }
        });
        return standingsLiveData;
    }
}
