package com.example.premierleagueapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Prediction;
import com.example.premierleagueapp.repositories.PredictionRepository;

public class PredictionActivityViewModel extends AndroidViewModel {
    private PredictionRepository predictionRepository;

    public PredictionActivityViewModel(@NonNull Application application) {
        super(application);
        predictionRepository = PredictionRepository.getInstance(application);
    }

    public int getHomeImage(String homeTeamName) {
        switch (homeTeamName) {
            case "Arsenal FC":
                return R.drawable.arsenal_fc;
            case "Aston Villa FC":
                return R.drawable.aston_villa;
            case "Chelsea FC":
                return R.drawable.chelsea;
            case "Everton FC":
                return R.drawable.everton;
            case "Liverpool FC":
                return R.drawable.liverpool;
            case "Manchester City FC":
                return R.drawable.manchester_city;
            case "Manchester United FC":
                return R.drawable.manchester_united;
            case "Newcastle United FC":
                return R.drawable.newcastle_united;
            case "Norwich City FC":
                return R.drawable.norwich_city;
            case "Tottenham Hotspur FC":
                return R.drawable.tottenham_hotspur;
            case "Wolverhampton Wanderers FC":
                return R.drawable.wolves;
            case "Burnley FC":
                return R.drawable.burnely;
            case "Leicester City FC":
                return R.drawable.leicester_city;
            case "Southampton FC":
                return R.drawable.southampton;
            case "Watford FC":
                return R.drawable.watford;
            case "Crystal Palace FC":
                return R.drawable.crystal_palace;
            case "Sheffield United FC":
                return R.drawable.sheffield_united;
            case "Brighton & Hove Albion FC":
                return R.drawable.brighton;
            case "West Ham United FC":
                return R.drawable.west_ham;
            case "AFC Bournemouth":
                return R.drawable.bournemonth;
        }
        return 0;
    }

    public int getAwayImage(String awayTeamName) {
        switch (awayTeamName) {
            case "Arsenal FC":
                return R.drawable.arsenal_fc;
            case "Aston Villa FC":
                return R.drawable.aston_villa;
            case "Chelsea FC":
                return R.drawable.chelsea;
            case "Everton FC":
                return R.drawable.everton;
            case "Liverpool FC":
                return R.drawable.liverpool;
            case "Manchester City FC":
                return R.drawable.manchester_city;
            case "Manchester United FC":
                return R.drawable.manchester_united;
            case "Newcastle United FC":
                return R.drawable.newcastle_united;
            case "Norwich City FC":
                return R.drawable.norwich_city;
            case "Tottenham Hotspur FC":
                return R.drawable.tottenham_hotspur;
            case "Wolverhampton Wanderers FC":
                return R.drawable.wolves;
            case "Burnley FC":
                return R.drawable.burnely;
            case "Leicester City FC":
                return R.drawable.leicester_city;
            case "Southampton FC":
                return R.drawable.southampton;
            case "Watford FC":
                return R.drawable.watford;
            case "Crystal Palace FC":
                return R.drawable.crystal_palace;
            case "Sheffield United FC":
                return R.drawable.sheffield_united;
            case "Brighton & Hove Albion FC":
                return R.drawable.brighton;
            case "West Ham United FC":
                return R.drawable.west_ham;
            case "AFC Bournemouth":
                return R.drawable.bournemonth;
        }
        return 0;
    }

    public void createPrediction(int id, int homeTeamScore, int awayTeamScore, String homeTeamName, String awayTeamName) {
        Prediction prediction = new Prediction(id, homeTeamName, awayTeamName, homeTeamScore, awayTeamScore);
        predictionRepository.createPrediction(prediction);
    }

    public LiveData<Prediction> getPrediction(int id) {
        return predictionRepository.getLivePrediction(id);
    }
}
