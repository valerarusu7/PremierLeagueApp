package com.example.premierleagueapp.requests.clients;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.premierleagueapp.model.Prediction;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PredictionAPIClient {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("predictions");
    private MutableLiveData<Prediction> livePrediction = new MutableLiveData<>();
    private Application application;

    public PredictionAPIClient(Application application) {
        this.application = application;
    }

    public void createPrediction(Prediction prediction) {
        if (prediction != null) {
            databaseReference.child(String.valueOf(prediction.getId())).setValue(prediction);
        }
    }

    public LiveData<Prediction> getLivePrediction(int id) {
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot routesSnapshot : dataSnapshot.getChildren()) {
                    Prediction prediction = routesSnapshot.getValue(Prediction.class);
                    if (routesSnapshot.getKey().equals(String.valueOf(id))) {
                        livePrediction.setValue(prediction);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return livePrediction;
    }
}
