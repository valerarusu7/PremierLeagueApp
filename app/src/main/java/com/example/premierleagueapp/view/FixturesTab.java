package com.example.premierleagueapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.adapter.RecyclerViewAdapterFixtures;
import com.example.premierleagueapp.viewmodel.FixturesTabViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FixturesTab extends Fragment {
    private RecyclerViewAdapterFixtures adapter;
    private ProgressBar progressBar;
    private FloatingActionButton go;
    private RecyclerView recyclerView;

    public FixturesTab() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(false);
        View view = inflater.inflate(R.layout.fixtures_fragment, container, false);
        progressBar = view.findViewById(R.id.progress_fixtures);
        go = view.findViewById(R.id.go);

        setRecycleView(view);
        setViewModel();

        return view;
    }

    public void setRecycleView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_matchday);
        adapter = new RecyclerViewAdapterFixtures();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        go.setOnClickListener(v -> recyclerView.smoothScrollToPosition(300));
    }

    private void setViewModel() {
        FixturesTabViewModel fixturesTabViewModel = new ViewModelProvider(this).get(FixturesTabViewModel.class);

        fixturesTabViewModel.getMatches().observe(getViewLifecycleOwner(), matches -> adapter.setMatches(matches));

        fixturesTabViewModel.getIsLoading().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else progressBar.setVisibility(View.GONE);
        });
    }
}
