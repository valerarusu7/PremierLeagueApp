package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamsRepository;

import java.util.ArrayList;

public class TeamTabViewModel extends AndroidViewModel {
    private TeamsRepository teamsRepository;

    public TeamTabViewModel(@NonNull Application application) {
        super(application);
        teamsRepository = TeamsRepository.getInstance(application);
    }

    public LiveData<ArrayList<Team>> getTeams() {
        return teamsRepository.getTeamsData();
    }

    public LiveData<Team> getFavoriteTeam() {
        return teamsRepository.getFavoriteTeam();
    }

    public int getFavoriteTeamDrawable(Team team) {
        switch (team.getName()) {
            case "Arsenal FC":
                return R.drawable.arsenal_fc;
            case "Aston Villa FC":
                return R.drawable.aston_villa;
            case "Chelsea FC":
                return R.drawable.chelsea;
            case "Everton FC":
                return R.drawable.everton;
            case "Liverpool FC":
                return R.drawable.liverpool;
            case "Manchester City FC":
                return R.drawable.manchester_city;
            case "Manchester United FC":
                return R.drawable.manchester_united;
            case "Newcastle United FC":
                return R.drawable.newcastle_united;
            case "Norwich City FC":
                return R.drawable.norwich_city;
            case "Tottenham Hotspur FC":
                return R.drawable.tottenham_hotspur;
            case "Wolverhampton Wanderers FC":
                return R.drawable.wolves;
            case "Burnley FC":
                return R.drawable.burnely;
            case "Leicester City FC":
                return R.drawable.leicester_city;
            case "Southampton FC":
                return R.drawable.southampton;
            case "Watford FC":
                return R.drawable.watford;
            case "Crystal Palace FC":
                return R.drawable.crystal_palace;
            case "Sheffield United FC":
                return R.drawable.sheffield_united;
            case "Brighton & Hove Albion FC":
                return R.drawable.brighton;
            case "West Ham United FC":
                return R.drawable.west_ham;
            case "AFC Bournemouth":
                return R.drawable.bournemonth;
        }
        return R.drawable.premier_league_logo;
    }
}
