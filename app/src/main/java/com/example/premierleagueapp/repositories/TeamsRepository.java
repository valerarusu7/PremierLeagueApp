package com.example.premierleagueapp.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.database.FavoriteTeamsDAO;
import com.example.premierleagueapp.database.FavoriteTeamsDatabase;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.requests.clients.TeamsAPIClient;

import java.util.ArrayList;

public class TeamsRepository {
    private static TeamsRepository instance;
    private TeamsAPIClient teamsAPIClient;
    private Application application;
    private FavoriteTeamsDAO favoriteTeamsDAO;
    private LiveData<Team> favoriteTeam;
    private FavoriteTeamsDatabase database;

    public TeamsRepository(Application application) {
        this.application = application;
        teamsAPIClient = new TeamsAPIClient(application);
        database = FavoriteTeamsDatabase.getInstance(application);
        favoriteTeamsDAO = database.getTeamsDAO();
        favoriteTeam = favoriteTeamsDAO.getFavoriteTeam();
    }

    public static TeamsRepository getInstance(Application application) {
        if (instance == null) {
            instance = new TeamsRepository(application);
        }
        return instance;
    }

    public LiveData<ArrayList<Team>> getTeamsData() {
        return teamsAPIClient.getTeamsLiveData();
    }

    public LiveData<Team> getFavoriteTeam() {
        return favoriteTeam;
    }

    public void insert(Team team) {
        new InsertRouteAsync(favoriteTeamsDAO).execute(team);
    }

    public void update(Team team) {
        if (favoriteTeamsDAO.getFavoriteTeam().getValue() != null) {
            new DeleteTeamAsync(favoriteTeamsDAO).execute(team);
        }
        new DeleteTeamAsync(favoriteTeamsDAO).execute(team);
        insert(team);
    }

    public LiveData<ArrayList<Team>> getTeams() {
        return teamsAPIClient.getTeamsForFavoriteLiveData();
    }

    private static class InsertRouteAsync extends AsyncTask<Team, Void, Void> {
        private FavoriteTeamsDAO dao;

        private InsertRouteAsync(FavoriteTeamsDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Team... Teams) {
            dao.insert(Teams[0]);
            return null;
        }
    }

    private static class DeleteTeamAsync extends AsyncTask<Team, Void, Void> {
        private FavoriteTeamsDAO dao;

        private DeleteTeamAsync(FavoriteTeamsDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Team... teams) {
            dao.clear();
            return null;
        }
    }

}


