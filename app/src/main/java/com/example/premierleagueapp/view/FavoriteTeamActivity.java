package com.example.premierleagueapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.viewmodel.FavoriteTeamActivityViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class FavoriteTeamActivity extends AppCompatActivity {
    private FavoriteTeamActivityViewModel favoriteTeamActivityViewModel;
    private Spinner spinner;
    private ArrayAdapter<Team> adapter;
    private ArrayList<Team> teamsList = new ArrayList<>();
    private ImageView imageView;
    private Team favoriteTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_team);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.imageViewFavTeam);

        setViewModel();
        initDropdown();

    }

    private void initDropdown() {
        spinner = findViewById(R.id.favorite_team_dropdown);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teamsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        favoriteTeamActivityViewModel.getTeams().observe(this, teams -> {
            teamsList.addAll(teams);
            spinner.setSelection(favoriteTeamActivityViewModel.getFavoriteTeamPosition(favoriteTeam));
            adapter.notifyDataSetChanged();
        });

    }

    private void setViewModel() {
        favoriteTeamActivityViewModel = new ViewModelProvider(this).get(FavoriteTeamActivityViewModel.class);

        favoriteTeamActivityViewModel.getFavoriteTeam().observe(this, team -> {
            if (team != null) {
                favoriteTeam = team;
                spinner.setSelection(favoriteTeamActivityViewModel.getFavoriteTeamPosition(favoriteTeam));
                Glide.with(imageView).load(team.getCrestUrl()).into(imageView);
            }
        });

    }

    public void onUpdateTeam(View view) {
        Team team = (Team) spinner.getSelectedItem();
        favoriteTeamActivityViewModel.updateTeam(team);

        finish();
    }
}