package com.example.premierleagueapp.adapter;

import android.annotation.SuppressLint;
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
import com.example.premierleagueapp.model.Match;
import com.example.premierleagueapp.model.Team;

import java.util.ArrayList;

public class RecyclerViewAdapterFixtures extends RecyclerView.Adapter<RecyclerViewAdapterFixtures.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapterFixtures";
    private ArrayList<Match> match;
    private OnListItemClickListener mOnListItemClickListener;

    public RecyclerViewAdapterFixtures(ArrayList<Match> match, OnListItemClickListener listener) {
        this.match = match;
        mOnListItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_list_iteam, parent, false);
        return new ViewHolder(view, mOnListItemClickListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapterFixtures.ViewHolder holder, final int position) {

        holder.matchday.setText("Matchday " + match.get(position).getMatchday());
        holder.homeTeam.setText(match.get(position).getHomeTeam().getName());
        holder.scoreHome.setText(String.valueOf(match.get(position).getScore().getFullTime().getHomeTeam()));
        holder.scoreAway.setText(String.valueOf(match.get(position).getScore().getFullTime().getAwayTeam()));
        holder.awayTeam.setText(match.get(position).getAwayTeam().getName());
        holder.date.setText(match.get(position).getUtcDate());

    }

    @Override
    public int getItemCount() {
        return match.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView matchday;
        TextView homeTeam;
        TextView scoreHome;
        TextView scoreAway;
        TextView awayTeam;
        TextView date;

        RelativeLayout parentLayout;
        OnListItemClickListener onListItemClickListener;

        public ViewHolder(@NonNull View itemView, OnListItemClickListener listener) {
            super(itemView);

            matchday = itemView.findViewById(R.id.matchday);
            homeTeam = itemView.findViewById(R.id.homeTeam);
            scoreHome = itemView.findViewById(R.id.scoreHome);
            scoreAway = itemView.findViewById(R.id.scoreAway);
            awayTeam = itemView.findViewById(R.id.awayTeam);
            date = itemView.findViewById(R.id.date);
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
