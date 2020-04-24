package com.example.premierleagueapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapterTeams extends RecyclerView.Adapter<RecyclerViewAdapterTeams.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<Team> teamsNames;
    private OnListItemClickListener mOnListItemClickListener;

    public RecyclerViewAdapterTeams(ArrayList<Team> teamsNames, OnListItemClickListener listener) {
        this.teamsNames = teamsNames;
        mOnListItemClickListener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view, mOnListItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.teamName.setText(teamsNames.get(position).getTeamName());

        //TODO:Setting image from local storage

    }

    @Override
    public int getItemCount() {
        return teamsNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView teamName;

        RelativeLayout parentLayout;
        OnListItemClickListener onListItemClickListener;

        public ViewHolder(@NonNull View itemView, OnListItemClickListener listener) {
            super(itemView);
            teamName = itemView.findViewById(R.id.teamName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            onListItemClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

}
