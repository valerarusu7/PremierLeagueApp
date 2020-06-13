package com.example.premierleagueapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Team;

import java.util.ArrayList;

public class RecyclerViewAdapterTeams extends RecyclerView.Adapter<RecyclerViewAdapterTeams.ViewHolder> {
    private ArrayList<Team> teamsNames;
    private OnListItemClickListener mOnListItemClickListener;

    public RecyclerViewAdapterTeams(OnListItemClickListener listener) {
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

        if (teamsNames != null) {
            holder.name.setText(teamsNames.get(position).getShortName());
            Glide.with(holder.parentLayout).load(teamsNames.get(position).getCrestUrl()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        if (teamsNames != null) {
            return teamsNames.size();
        }
        return 0;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teamsNames = teams;
        notifyDataSetChanged();
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView name;

        RelativeLayout parentLayout;
        OnListItemClickListener onListItemClickListener;

        public ViewHolder(@NonNull View itemView, OnListItemClickListener listener) {
            super(itemView);

            name = itemView.findViewById(R.id.teamName);
            imageView = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            onListItemClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

}
