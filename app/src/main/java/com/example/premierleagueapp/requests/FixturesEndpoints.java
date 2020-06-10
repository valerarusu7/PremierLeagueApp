package com.example.premierleagueapp.requests;

import com.example.premierleagueapp.model.Matches;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FixturesEndpoints {

    @GET("/v2/competitions/PL/matches")
    Call<Matches> getFixtures(@Header("X-Auth-Token") String authToken);

}
