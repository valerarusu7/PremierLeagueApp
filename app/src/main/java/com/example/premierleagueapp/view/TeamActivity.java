package com.example.premierleagueapp.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.premierleagueapp.R;
import com.example.premierleagueapp.adapter.RecycleViewAdapterTeamDetails;
import com.example.premierleagueapp.viewmodel.TeamActivityViewModel;

import java.util.Objects;

public class TeamActivity extends AppCompatActivity {
    private RecycleViewAdapterTeamDetails adapter;
    private int id;
    private String url;
    private TextView teamName;
    private TextView shortName;
    private TextView tla;
    private TextView address;
    private TextView phone;
    private TextView website;
    private TextView email;
    private TextView founded;
    private TextView clubColors;
    private TextView venue;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_activity);
        imageView = findViewById(R.id.imageViewTeam);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(TeamsTab.TEAM)) {
            id = bundle.getInt(TeamsTab.TEAM);
        }
        if (bundle != null) {
            url = bundle.getString("image");
        }
        setViewModel();
        RecyclerView recyclerView = findViewById(R.id.squad);
        adapter = new RecycleViewAdapterTeamDetails();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    private void setTextViews() {
        teamName = findViewById(R.id.teamName);
        shortName = findViewById(R.id.shortName);
        tla = findViewById(R.id.tla);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        website = findViewById(R.id.website);
        email = findViewById(R.id.email);
        founded = findViewById(R.id.founded);
        clubColors = findViewById(R.id.clubColors);
        venue = findViewById(R.id.venue);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void setViewModel() {
        TeamActivityViewModel teamActivityViewModel = new ViewModelProvider(this).get(TeamActivityViewModel.class);

        teamActivityViewModel.getTeam(id).observe(this, team -> {
            setTitle(team.getName());
            adapter.setTeam(team);
            setTextViews();
            address.setText(team.getAddress());
            clubColors.setText(team.getClubColors());
            email.setText(team.getEmail());
            founded.setText(String.valueOf(team.getFounded()));
            teamName.setText(team.getName());
            shortName.setText(team.getShortName());
            phone.setText(team.getPhone());
            venue.setText(team.getVenue());
            website.setText(team.getWebsite());
            tla.setText(team.getTla());
            Glide.with(imageView).load(url).into(imageView);
        });
    }

}
