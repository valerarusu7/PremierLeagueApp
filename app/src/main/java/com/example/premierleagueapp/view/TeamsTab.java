package com.example.premierleagueapp.view;

import android.content.Intent;
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
import com.example.premierleagueapp.adapter.RecyclerViewAdapterTeams;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.viewmodel.TeamTabViewModel;

import java.util.List;

public class TeamsTab extends Fragment implements RecyclerViewAdapterTeams.OnListItemClickListener {
    private RecyclerViewAdapterTeams adapter;
    private TeamTabViewModel teamTabViewModel;
    static final String TEAM = "Team";

    public TeamsTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setViewModel();

        return inflater.inflate(R.layout.teams_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_teams);
        adapter = new RecyclerViewAdapterTeams(teamTabViewModel.getTeams().getValue(), this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    private void setViewModel() {
        teamTabViewModel = new ViewModelProvider(this).get(TeamTabViewModel.class);
        teamTabViewModel.init();

        teamTabViewModel.getTeams().observe(getViewLifecycleOwner(), new Observer<List<Team>>() {

            @Override
            public void onChanged(List<Team> artworks) {
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(getActivity(), TeamActivity.class);
        intent.putExtra(TEAM, clickedItemIndex);
        startActivity(intent);

    }

}
