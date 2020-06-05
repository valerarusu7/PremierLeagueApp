package com.example.premierleagueapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.adapter.RecycleViewAdapterTeamDetails;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.viewmodel.TeamActivityViewModel;

import java.util.Objects;

public class TeamActivity extends AppCompatActivity {
    private TeamActivityViewModel teamActivityViewModel;
    private RecycleViewAdapterTeamDetails adapter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey(TeamsTab.TEAM)) {
            id = bundle.getInt(TeamsTab.TEAM);
        }

        setViewModel();
        RecyclerView recyclerView = findViewById(R.id.squad);
        adapter = new RecycleViewAdapterTeamDetails();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//        setTitle(teamActivityViewModel.getTeam().getValue().getName());

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void setViewModel() {
        teamActivityViewModel = new ViewModelProvider(this).get(TeamActivityViewModel.class);

        teamActivityViewModel.getTeam(id).observe(this, team -> {
                adapter.setTeam(team);
                adapter.notifyDataSetChanged();
        });

    }

}
