package com.example.premierleagueapp.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.football-data.org")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static FixturesEndpoints fixturesEndpoints = retrofit.create(FixturesEndpoints.class);

    private static TableEndpoints tableEndpoints = retrofit.create(TableEndpoints.class);

    private static TeamEndpoints teamEndpoints = retrofit.create(TeamEndpoints.class);

    private static TeamsEndpoints teamsEndpoints = retrofit.create(TeamsEndpoints.class);

    public static FixturesEndpoints getFixturesEndpoints() {
        return fixturesEndpoints;
    }

    public static TableEndpoints getTableEndpoints() {
        return tableEndpoints;
    }

    public static TeamEndpoints getTeamEndpoints() {
        return teamEndpoints;
    }

    public static TeamsEndpoints getTeamsEndpoints() {
        return teamsEndpoints;
    }
}
