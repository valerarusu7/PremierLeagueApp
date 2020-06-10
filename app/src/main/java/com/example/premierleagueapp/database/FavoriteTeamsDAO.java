package com.example.premierleagueapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.premierleagueapp.model.Team;

@Dao
public interface FavoriteTeamsDAO {

    @Insert
    void insert(Team team);

    @Update
    void update(Team team);

    @Query("SELECT * FROM favorite_team_table")
    LiveData<Team> getFavoriteTeam();

    @Query("DELETE FROM favorite_team_table")
    void clear();

}
