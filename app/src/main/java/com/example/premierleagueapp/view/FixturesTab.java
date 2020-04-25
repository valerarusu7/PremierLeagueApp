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
import com.example.premierleagueapp.adapter.RecyclerViewAdapterFixtures;
import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.model.Team;
import com.example.premierleagueapp.viewmodel.FixturesTabViewModel;
import com.example.premierleagueapp.viewmodel.TeamTabViewModel;

import java.util.List;

public class FixturesTab extends Fragment implements RecyclerViewAdapterFixtures.OnListItemClickListener{
    private RecyclerViewAdapterFixtures adapter;
    private FixturesTabViewModel fixturesTabViewModel;

    public FixturesTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setViewModel();

        return inflater.inflate(R.layout.fixtures_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_matchday);
        adapter = new RecyclerViewAdapterFixtures(fixturesTabViewModel.getMatches().getValue(), this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    private void setViewModel() {
        fixturesTabViewModel = new ViewModelProvider(this).get(FixturesTabViewModel.class);
        fixturesTabViewModel.init();

        fixturesTabViewModel.getMatches().observe(getViewLifecycleOwner(), new Observer<List<Match>>() {

            @Override
            public void onChanged(List<Match> matches) {
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
