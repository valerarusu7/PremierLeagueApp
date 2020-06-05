package com.example.premierleagueapp.requests;

import com.example.premierleagueapp.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface TeamEndpoints {

    @GET("/v2/teams/{id}")
    Call<Team> getTeamById(@Path("id") int id, @Header("X-Auth-Token") String authToken);

}
