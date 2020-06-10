package com.example.premierleagueapp.requests;

import com.example.premierleagueapp.model.Teams;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TeamsEndpoints {

    @GET("/v2/competitions/2021/teams")
    Call<Teams> getTeams(@Header("X-Auth-Token") String authToken);

}
