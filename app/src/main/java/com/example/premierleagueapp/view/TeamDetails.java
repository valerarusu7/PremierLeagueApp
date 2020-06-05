package com.example.premierleagueapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.adapter.RecycleViewAdapterTeamDetails;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.viewmodel.TeamActivityViewModel;

public class TeamDetails extends Fragment {
    private TeamActivityViewModel teamActivityViewModel;
    private RecycleViewAdapterTeamDetails adapter;
    private int id;

    public TeamDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        id = bundle.getInt("TeamID");
        setViewModel();

        return inflater.inflate(R.layout.team_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.squad);
        adapter = new RecycleViewAdapterTeamDetails();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void setViewModel() {
        teamActivityViewModel = new ViewModelProvider(this).get(TeamActivityViewModel.class);

        teamActivityViewModel.getTeam(id).observe(getViewLifecycleOwner(), team -> {
            adapter.setTeam(team);
            adapter.notifyDataSetChanged();
        });

    }


}
