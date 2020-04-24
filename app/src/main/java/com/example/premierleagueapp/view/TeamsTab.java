package com.example.premierleagueapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class TeamsTab extends Fragment implements RecyclerViewAdapterTeams.OnListItemClickListener {
    private RecyclerViewAdapterTeams adapter;

    public TeamsTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.teams_fragment, container, false);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
