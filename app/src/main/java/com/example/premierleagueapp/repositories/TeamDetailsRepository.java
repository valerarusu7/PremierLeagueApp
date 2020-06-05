package com.example.premierleagueapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.Player;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.requests.ServiceGenerator;
import com.example.premierleagueapp.requests.TeamEndpoints;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailsRepository {
    private static TeamDetailsRepository instance;
    private ArrayList<Player> squad;
    private Team team;
    private static final String TOKEN = "f3a2512d06ae44e68a95be8689245c1f";

    private TeamDetailsRepository() {
        squad = new ArrayList<>();
    }

    public static TeamDetailsRepository getInstance() {
        if (instance == null) {
            instance = new TeamDetailsRepository();
        }
        return instance;
    }

    public MutableLiveData<Team> getTeamByIdData(int id) {
        squad = new ArrayList<>();
        setTeamById(id);

        MutableLiveData<Team> data = new MutableLiveData<>();
        data.setValue(team);
        return data;
    }

    private void setTeamById(int id) {
        TeamEndpoints endpoints = ServiceGenerator.getTeamEndpoints();

        Call<Team> call = endpoints.getTeamById(id, TOKEN);
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                System.out.println("SUCCESSFUL LOAD OF : TEAM " + response.body());
                Team apiTeam = response.body();
                if(response.isSuccessful() && apiTeam != null) {
                    squad = new ArrayList<>(apiTeam.getSquad());
                    team = new Team(apiTeam.getId(), apiTeam.getArea(), apiTeam.getActiveCompetitions(), apiTeam.getName(), apiTeam.getShortName(), apiTeam.getTla(),
                            apiTeam.getCrestUrl(), apiTeam.getAddress(), apiTeam.getPhone(), apiTeam.getWebsite(), apiTeam.getEmail(),
                            apiTeam.getFounded(), apiTeam.getClubColors(), apiTeam.getVenue(), squad, apiTeam.getLastUpdated());
                }
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                System.out.println("Failed to load the data from api : TEAMS");

            }
        });
    }


}
