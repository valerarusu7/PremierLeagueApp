package com.example.premierleagueapp.adapter;

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

import java.util.ArrayList;

public class RecyclerViewAdapterFixtures extends RecyclerView.Adapter<RecyclerViewAdapterFixtures.ViewHolder> {
    private ArrayList<Match> match;

    public RecyclerViewAdapterFixtures() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.homeTeam.setText(match.get(position).getHomeTeam().getName());
        holder.scoreHome.setText(String.valueOf(match.get(position).getScore().getFullTime().getHomeTeam()));
        holder.scoreAway.setText(String.valueOf(match.get(position).getScore().getFullTime().getAwayTeam()));
        holder.awayTeam.setText(match.get(position).getAwayTeam().getName());

        switch (match.get(position).getHomeTeam().getName()) {
            case "Arsenal FC":
                holder.homeImage.setImageResource(R.drawable.arsenal_fc);
                break;
            case "Aston Villa FC":
                holder.homeImage.setImageResource(R.drawable.aston_villa);
                break;
            case "Chelsea FC":
                holder.homeImage.setImageResource(R.drawable.chelsea);
                break;
            case "Everton FC":
                holder.homeImage.setImageResource(R.drawable.everton);
                break;
            case "Liverpool FC":
                holder.homeImage.setImageResource(R.drawable.liverpool);
                break;
            case "Manchester City FC":
                holder.homeImage.setImageResource(R.drawable.manchester_city);
                break;
            case "Manchester United FC":
                holder.homeImage.setImageResource(R.drawable.manchester_united);
                break;
            case "Newcastle United FC":
                holder.homeImage.setImageResource(R.drawable.newcastle_united);
                break;
            case "Norwich City FC":
                holder.homeImage.setImageResource(R.drawable.norwich_city);
                break;
            case "Tottenham Hotspur FC":
                holder.homeImage.setImageResource(R.drawable.tottenham_hotspur);
                break;
            case "Wolverhampton Wanderers FC":
                holder.homeImage.setImageResource(R.drawable.wolves);
                break;
            case "Burnley FC":
                holder.homeImage.setImageResource(R.drawable.burnely);
                break;
            case "Leicester City FC":
                holder.homeImage.setImageResource(R.drawable.leicester_city);
                break;
            case "Southampton FC":
                holder.homeImage.setImageResource(R.drawable.southampton);
                break;
            case "Watford FC":
                holder.homeImage.setImageResource(R.drawable.watford);
                break;
            case "Crystal Palace FC":
                holder.homeImage.setImageResource(R.drawable.crystal_palace);
                break;
            case "Sheffield United FC":
                holder.homeImage.setImageResource(R.drawable.sheffield_united);
                break;
            case "Brighton & Hove Albion FC":
                holder.homeImage.setImageResource(R.drawable.brighton);
                break;
            case "West Ham United FC":
                holder.homeImage.setImageResource(R.drawable.west_ham);
                break;
            case "AFC Bournemouth":
                holder.homeImage.setImageResource(R.drawable.bournemonth);
                break;
        }

        switch (match.get(position).getAwayTeam().getName()) {
            case "Arsenal FC":
                holder.awayImage.setImageResource(R.drawable.arsenal_fc);
                break;
            case "Aston Villa FC":
                holder.awayImage.setImageResource(R.drawable.aston_villa);
                break;
            case "Chelsea FC":
                holder.awayImage.setImageResource(R.drawable.chelsea);
                break;
            case "Everton FC":
                holder.awayImage.setImageResource(R.drawable.everton);
                break;
            case "Liverpool FC":
                holder.awayImage.setImageResource(R.drawable.liverpool);
                break;
            case "Manchester City FC":
                holder.awayImage.setImageResource(R.drawable.manchester_city);
                break;
            case "Manchester United FC":
                holder.awayImage.setImageResource(R.drawable.manchester_united);
                break;
            case "Newcastle United FC":
                holder.awayImage.setImageResource(R.drawable.newcastle_united);
                break;
            case "Norwich City FC":
                holder.awayImage.setImageResource(R.drawable.norwich_city);
                break;
            case "Tottenham Hotspur FC":
                holder.awayImage.setImageResource(R.drawable.tottenham_hotspur);
                break;
            case "Wolverhampton Wanderers FC":
                holder.awayImage.setImageResource(R.drawable.wolves);
                break;
            case "Burnley FC":
                holder.awayImage.setImageResource(R.drawable.burnely);
                break;
            case "Leicester City FC":
                holder.awayImage.setImageResource(R.drawable.leicester_city);
                break;
            case "Southampton FC":
                holder.awayImage.setImageResource(R.drawable.southampton);
                break;
            case "Watford FC":
                holder.awayImage.setImageResource(R.drawable.watford);
                break;
            case "Crystal Palace FC":
                holder.awayImage.setImageResource(R.drawable.crystal_palace);
                break;
            case "Sheffield United FC":
                holder.awayImage.setImageResource(R.drawable.sheffield_united);
                break;
            case "Brighton & Hove Albion FC":
                holder.awayImage.setImageResource(R.drawable.brighton);
                break;
            case "West Ham United FC":
                holder.awayImage.setImageResource(R.drawable.west_ham);
                break;
            case "AFC Bournemouth":
                holder.awayImage.setImageResource(R.drawable.bournemonth);
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (match != null) {
            return match.size();
        }
        return 0;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.match = matches;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView homeTeam;
        TextView scoreHome;
        TextView scoreAway;
        TextView awayTeam;
        ImageView homeImage;
        ImageView awayImage;

        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            homeTeam = itemView.findViewById(R.id.homeTeam);
            scoreHome = itemView.findViewById(R.id.scoreHome);
            scoreAway = itemView.findViewById(R.id.scoreAway);
            awayTeam = itemView.findViewById(R.id.awayTeam);
            homeImage = itemView.findViewById(R.id.homeImage);
            awayImage = itemView.findViewById(R.id.awayImage);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }


}
