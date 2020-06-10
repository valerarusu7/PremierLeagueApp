package com.example.premierleagueapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.viewmodel.PredictionActivityViewModel;

public class PredictionActivity extends AppCompatActivity {
    private PredictionActivityViewModel predictionActivityViewModel;
    private TextView homeTeam;
    private TextView awayTeam;
    private TextView homeGoals;
    private TextView awayGoals;
    private ImageView homeImage;
    private ImageView awayImage;
    private EditText homeScore;
    private EditText awayScore;
    private String homeTeamName;
    private String awayTeamName;
    private int id;
    private Button button;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        homeTeamName = getIntent().getStringExtra("homeTeamName");
        awayTeamName = getIntent().getStringExtra("awayTeamName");
        id = getIntent().getIntExtra("id", 0);
        findViews();
        setViewModel();
        setImages();
        setButton();
    }

    private void findViews() {
        homeImage = findViewById(R.id.image_prediction_home);
        awayImage = findViewById(R.id.image_prediction_away);
        homeScore = findViewById(R.id.prediction_home);
        awayScore = findViewById(R.id.prediction_away);
        homeTeam = findViewById(R.id.home_name_prediction);
        awayTeam = findViewById(R.id.away_name_prediction);
        homeGoals = findViewById(R.id.home_goals);
        awayGoals = findViewById(R.id.away_goals);
        button = findViewById(R.id.predict);
        linearLayout = findViewById(R.id.prediction_layout);
    }

    @SuppressLint("SetTextI18n")
    private void setViewModel() {
        predictionActivityViewModel = new ViewModelProvider(this).get(PredictionActivityViewModel.class);

        predictionActivityViewModel.getPrediction(id).observe(this, prediction -> {
            if (prediction.getId() == id) {
                homeScore.setHint(String.valueOf(prediction.getHomeScore()));
                awayScore.setHint(String.valueOf(prediction.getAwayScore()));
                homeTeam.setText(prediction.getHomeTeam());
                awayTeam.setText(prediction.getAwayTeam());
                homeGoals.setText(prediction.getHomeScore() + " goals");
                awayGoals.setText(prediction.getAwayScore() + " goals");
            } else {
                homeTeam.setText("Home Team: -");
                awayTeam.setText("Away Team: -");
                homeGoals.setText(R.string.dash);
                awayGoals.setText(R.string.dash);
            }
        });
    }

    private void setImages() {
        int home = predictionActivityViewModel.getHomeImage(homeTeamName);
        int away = predictionActivityViewModel.getAwayImage(awayTeamName);
        homeImage.setImageResource(home);
        awayImage.setImageResource(away);
    }

    private void createPrediction() {
        if(!homeScore.getText().toString().equals("") && !awayScore.getText().toString().equals("")) {
            int homeTeamScore = Integer.parseInt(homeScore.getText().toString());
            int awayTeamScore = Integer.parseInt(awayScore.getText().toString());
            predictionActivityViewModel.createPrediction(id, homeTeamScore, awayTeamScore, homeTeamName, awayTeamName);
        } else {
            homeScore.setError("Set Prediction");
            awayScore.setError("Set Prediction");
        }
    }

    public void setButton() {
        button.setOnClickListener(v -> createPrediction());
    }
}