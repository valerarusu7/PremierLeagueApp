package com.example.premierleagueapp.view;

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
import com.example.premierleagueapp.adapter.RecyclerViewAdapterTable;
import com.example.premierleagueapp.viewmodel.TableTabViewModel;

public class TableTab extends Fragment implements RecyclerViewAdapterTable.OnListItemClickListener {
    private TableTabViewModel tableTabViewModel;
    private RecyclerViewAdapterTable adapter;

    public TableTab() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(false);
        setViewModel();

        return inflater.inflate(R.layout.table_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_table);
        adapter = new RecyclerViewAdapterTable(tableTabViewModel.getStandings().getValue(), this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    private void setViewModel() {
        tableTabViewModel = new ViewModelProvider(this).get(TableTabViewModel.class);

        tableTabViewModel.getStandings().observe(getViewLifecycleOwner(), tables -> adapter.setTable(tables));
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
