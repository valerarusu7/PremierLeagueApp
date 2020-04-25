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
import com.example.premierleagueapp.adapter.RecyclerViewAdapterTable;
import com.example.premierleagueapp.model.Table;
import com.example.premierleagueapp.viewmodel.TableTabViewModel;

import java.util.List;

public class TableTab extends Fragment implements RecyclerViewAdapterTable.OnListItemClickListener{
    private TableTabViewModel tableTabViewModel;
    private RecyclerViewAdapterTable adapter;

    public TableTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        tableTabViewModel.init();

        tableTabViewModel.getStandings().observe(getViewLifecycleOwner(), new Observer<List<Table>>() {

            @Override
            public void onChanged(List<Table> tables) {
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
