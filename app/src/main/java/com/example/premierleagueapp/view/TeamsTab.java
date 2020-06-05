package com.example.premierleagueapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.adapter.RecyclerViewAdapterTeams;
import com.example.premierleagueapp.viewmodel.TeamTabViewModel;

public class TeamsTab extends Fragment implements RecyclerViewAdapterTeams.OnListItemClickListener {
    static final String TEAM = "Team";
    private RecyclerViewAdapterTeams adapter;
    private TeamTabViewModel teamTabViewModel;

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
        adapter = new RecyclerViewAdapterTeams(this);
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
        teamTabViewModel = new ViewModelProvider(this).get(TeamTabViewModel.class);

        teamTabViewModel.getTeams().observe(getViewLifecycleOwner(), teams -> {
            adapter.setTeams(teams);
        });
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        int teamID = teamTabViewModel.getTeams().getValue().get(clickedItemIndex).getId();
        Intent intent = new Intent(getActivity(), TeamActivity.class);
        intent.putExtra(TEAM, teamID);
        System.out.println(teamTabViewModel.getTeams().getValue().get(clickedItemIndex).getId());
        startActivity(intent);
    }
}
