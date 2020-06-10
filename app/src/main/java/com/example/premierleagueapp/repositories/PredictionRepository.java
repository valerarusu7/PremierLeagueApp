package com.example.premierleagueapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.premierleagueapp.model.Prediction;
import com.example.premierleagueapp.requests.clients.PredictionAPIClient;

public class PredictionRepository {
    private static PredictionRepository instance;
    private PredictionAPIClient predictionAPIClient;

    public static PredictionRepository getInstance(Application application) {
        if (instance == null) {
            instance = new PredictionRepository(application);
        }
        return instance;
    }

    public PredictionRepository(Application application) {
        predictionAPIClient = new PredictionAPIClient(application);
    }


    public void createPrediction(Prediction prediction) {
        predictionAPIClient.createPrediction(prediction);
    }

    public LiveData<Prediction> getLivePrediction(int id) {
        return predictionAPIClient.getLivePrediction(id);
    }
}
