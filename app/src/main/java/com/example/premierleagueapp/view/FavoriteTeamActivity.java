package com.example.premierleagueapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.viewmodel.FavoriteTeamActivityViewModel;

import java.util.ArrayList;

public class FavoriteTeamActivity extends AppCompatActivity {
    private FavoriteTeamActivityViewModel favoriteTeamActivityViewModel;
    private Spinner spinner;
    private ArrayList<Team> teamsList = new ArrayList<>();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_team);
        imageView = findViewById(R.id.imageViewFavTeam);

        setViewModel();
        initDropdown();
    }

    private void initDropdown() {
        spinner = findViewById(R.id.favorite_team_dropdown);
        final ArrayAdapter<Team> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, teamsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        favoriteTeamActivityViewModel.getTeams().observe(this, teams -> {
            teamsList.addAll(teams);
            adapter.notifyDataSetChanged();
        });

    }

    private void setViewModel() {
        favoriteTeamActivityViewModel = new ViewModelProvider(this).get(FavoriteTeamActivityViewModel.class);

        favoriteTeamActivityViewModel.getFavoriteTeam().observe(this, team -> {
            if(team != null) {
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