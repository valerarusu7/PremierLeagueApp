package com.example.premierleagueapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.example.premierleagueapp.model.Teams;
import com.example.premierleagueapp.viewmodel.TeamTabViewModel;

public class TeamsTab extends Fragment implements RecyclerViewAdapterTeams.OnListItemClickListener {
    static final String TEAM = "Team";
    private RecyclerViewAdapterTeams adapter;
    private TeamTabViewModel teamTabViewModel;
    private Teams myTeams;
    private MenuItem fav_team;
    private View view;

    public TeamsTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.teams_fragment, container, false);
        setHasOptionsMenu(true);
        fav_team = view.findViewById(R.id.fav_team);
        setViewModel();

        return view;
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
            myTeams = new Teams(0, null, null, null, teams);
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar, menu);

        fav_team = menu.findItem(R.id.fav_team);
        fav_team.getActionView();

        teamTabViewModel.getFavoriteTeam().observe(getViewLifecycleOwner(), team -> {
            if (team != null) {
                fav_team.setIcon(teamTabViewModel.getFavoriteTeamDrawable(team));
            }
        });

        fav_team.setOnMenuItemClickListener(menuItem -> {
            Intent intent = new Intent(getActivity(), FavoriteTeamActivity.class);
            startActivity(intent);
            return true;
        });

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        int teamID = myTeams.getTeams().get(clickedItemIndex).getId();
        Intent intent = new Intent(getActivity(), TeamActivity.class);
        intent.putExtra(TEAM, teamID);
        intent.putExtra("image", myTeams.getTeams().get(clickedItemIndex).getCrestUrl());
        System.out.println(teamTabViewModel.getTeams().getValue().get(clickedItemIndex).getId());
        startActivity(intent);
    }
}
