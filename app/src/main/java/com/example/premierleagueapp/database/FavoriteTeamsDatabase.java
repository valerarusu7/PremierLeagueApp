package com.example.premierleagueapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.premierleagueapp.model.Team;

@Database(entities = Team.class, version = 10)
public abstract class FavoriteTeamsDatabase extends RoomDatabase {
    private static FavoriteTeamsDatabase instance;

    public static synchronized FavoriteTeamsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FavoriteTeamsDatabase.class, "favorite_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract FavoriteTeamsDAO getTeamsDAO();
}
