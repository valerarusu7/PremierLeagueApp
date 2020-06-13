package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.repositories.TeamsRepository;

import java.util.ArrayList;

public class FavoriteTeamActivityViewModel extends AndroidViewModel {
    private TeamsRepository teamsRepository;

    public FavoriteTeamActivityViewModel(@NonNull Application application) {
        super(application);
        teamsRepository = TeamsRepository.getInstance(application);
    }


    public LiveData<ArrayList<Team>> getTeams() {
        return teamsRepository.getTeams();
    }

    public void updateTeam(Team team) {
        teamsRepository.update(team);
    }

    public LiveData<Team> getFavoriteTeam() {
        return teamsRepository.getFavoriteTeam();
    }

    public int getFavoriteTeamPosition(Team team) {
            switch (team.getName()) {
                case "Arsenal FC":
                    return 0;
                case "Aston Villa FC":
                    return 1;
                case "Chelsea FC":
                    return 2;
                case "Everton FC":
                    return 3;
                case "Liverpool FC":
                    return 4;
                case "Manchester City FC":
                    return 5;
                case "Manchester United FC":
                    return 6;
                case "Newcastle United FC":
                    return 7;
                case "Norwich City FC":
                    return 8;
                case "Tottenham Hotspur FC":
                    return 9;
                case "Wolverhampton Wanderers FC":
                    return 10;
                case "Burnley FC":
                    return 11;
                case "Leicester City FC":
                    return 12;
                case "Southampton FC":
                    return 13;
                case "Watford FC":
                    return 14;
                case "Crystal Palace FC":
                    return 15;
                case "Sheffield United FC":
                    return 16;
                case "Brighton & Hove Albion FC":
                    return 17;
                case "West Ham United FC":
                    return 18;
                case "AFC Bournemouth":
                    return 19;
        }
        return 0;
    }
}
