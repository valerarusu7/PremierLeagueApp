package com.example.premierleagueapp.requests;

import com.example.premierleagueapp.model.CompetitionStandings;
import com.example.premierleagueapp.model.Standings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TableEndpoints {

    @GET("/v2/competitions/2021/standings?standingType=TOTAL")
    Call<CompetitionStandings> getTable(@Header("X-Auth-Token") String authToken);

}
