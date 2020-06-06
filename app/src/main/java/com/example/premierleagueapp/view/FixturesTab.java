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
import com.example.premierleagueapp.viewmodel.FixturesTabViewModel;

import java.util.ArrayList;

public class FixturesTab extends Fragment {
    private RecyclerViewAdapterFixtures adapter;
    private FixturesTabViewModel fixturesTabViewModel;

    public FixturesTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(false);
        setViewModel();

        return inflater.inflate(R.layout.fixtures_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_matchday);
        adapter = new RecyclerViewAdapterFixtures();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    private void setViewModel() {
        fixturesTabViewModel = new ViewModelProvider(this).get(FixturesTabViewModel.class);

        fixturesTabViewModel.getMatches().observe(getViewLifecycleOwner(), matches -> adapter.setMatches(matches));
    }
}
