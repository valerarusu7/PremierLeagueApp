package com.example.premierleagueapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Team;

import java.util.ArrayList;

public class RecyclerViewAdapterTeams extends RecyclerView.Adapter<RecyclerViewAdapterTeams.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapterTeams";
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

        holder.name.setText(teamsNames.get(position).getShortName());

    }

    @Override
    public int getItemCount() {
        return teamsNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

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

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

}
