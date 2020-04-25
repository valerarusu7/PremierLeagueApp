package com.example.premierleagueapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.viewmodel.TeamActivityViewModel;

import java.util.Objects;

public class TeamActivity extends AppCompatActivity {
    private TeamActivityViewModel teamActivityViewModel;
    private int position;
    private TextView id;
    private TextView name;
    private TextView shortName;
    private TextView tla;
    private TextView address;
    private TextView phone;
    private TextView website;
    private TextView email;
    private TextView founded;
    private TextView clubColors;
    private TextView venue;
    private TextView lastUpdated;
    private ImageView crestUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey(TeamsTab.TEAM)) {
            position = bundle.getInt(TeamsTab.TEAM);
        }

        setViewModel();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle(teamActivityViewModel.getName());

        findViews();
        setTextFields();
    }

    private void setViewModel() {
        teamActivityViewModel = new ViewModelProvider(this).get(TeamActivityViewModel.class);
        teamActivityViewModel.init(position);
    }

    public void findViews() {
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        shortName = findViewById(R.id.shortName);
        tla = findViewById(R.id.tla);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        website = findViewById(R.id.website);
        email = findViewById(R.id.email);
        founded = findViewById(R.id.founded);
        clubColors = findViewById(R.id.clubColors);
        venue = findViewById(R.id.venue);
        lastUpdated = findViewById(R.id.lastUpdated);
        crestUrl = findViewById(R.id.crestUrl);
    }

    public void setTextFields() {
        id.setText(String.valueOf(teamActivityViewModel.getId()));
        name.setText(teamActivityViewModel.getName());
        shortName.setText(teamActivityViewModel.getShortName());
        tla.setText(teamActivityViewModel.getTla());
        address.setText(teamActivityViewModel.getAddress());
        phone.setText(teamActivityViewModel.getPhone());
        website.setText(teamActivityViewModel.getWebsite());
        email.setText(teamActivityViewModel.getEmail());
        founded.setText(String.valueOf(teamActivityViewModel.getFounded()));
        clubColors.setText(teamActivityViewModel.getClubColors());
        venue.setText(teamActivityViewModel.getVenue());
        lastUpdated.setText(teamActivityViewModel.getLastUpdated());
        crestUrl.setImageURI(Uri.parse(teamActivityViewModel.getCrestUrl()));
        System.out.println(teamActivityViewModel.getCrestUrl());
    }
}
