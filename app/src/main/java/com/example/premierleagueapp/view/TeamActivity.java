package com.example.premierleagueapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.viewmodel.TeamActivityViewModel;

import java.util.Objects;

public class TeamActivity extends AppCompatActivity {
    private TeamActivityViewModel teamActivityViewModel;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_activity);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey(TeamsTab.TEAM)) {
            position = bundle.getInt(TeamsTab.TEAM);
        }

        setViewModel();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle(teamActivityViewModel.getName());

    }

    private void setViewModel() {
        teamActivityViewModel = new ViewModelProvider(this).get(TeamActivityViewModel.class);
        teamActivityViewModel.init(position);
    }
}
