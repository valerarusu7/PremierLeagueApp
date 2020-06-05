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
    private static final String TAG = "RecyclerViewAdapterFixtures";
    private ArrayList<Match> match;

    public RecyclerViewAdapterFixtures() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_list_iteam, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.homeTeam.setText(match.get(position).getHomeTeam().getName());
        holder.scoreHome.setText(String.valueOf(match.get(position).getScore().getFullTime().getHomeTeam()));
        holder.scoreAway.setText(String.valueOf(match.get(position).getScore().getFullTime().getAwayTeam()));
        holder.awayTeam.setText(match.get(position).getAwayTeam().getName());

        if (match.get(position).getHomeTeam().getName().equals("Arsenal FC")) {
            holder.homeImage.setImageResource(R.drawable.arsenal_fc);
        } else if (match.get(position).getHomeTeam().getName().equals("Aston Villa FC")) {
            holder.homeImage.setImageResource(R.drawable.aston_villa);
        } else if (match.get(position).getHomeTeam().getName().equals("Chelsea FC")) {
            holder.homeImage.setImageResource(R.drawable.chelsea);
        } else if (match.get(position).getHomeTeam().getName().equals("Everton FC")) {
            holder.homeImage.setImageResource(R.drawable.everton);
        } else if (match.get(position).getHomeTeam().getName().equals("Liverpool FC")) {
            holder.homeImage.setImageResource(R.drawable.liverpool);
        } else if (match.get(position).getHomeTeam().getName().equals("Manchester City FC")) {
            holder.homeImage.setImageResource(R.drawable.manchester_city);
        } else if (match.get(position).getHomeTeam().getName().equals("Manchester United FC")) {
            holder.homeImage.setImageResource(R.drawable.manchester_united);
        } else if (match.get(position).getHomeTeam().getName().equals("Newcastle United FC")) {
            holder.homeImage.setImageResource(R.drawable.newcastle_united);
        } else if (match.get(position).getHomeTeam().getName().equals("Norwich City FC")) {
            holder.homeImage.setImageResource(R.drawable.norwich_city);
        } else if (match.get(position).getHomeTeam().getName().equals("Tottenham Hotspur FC")) {
            holder.homeImage.setImageResource(R.drawable.tottenham_hotspur);
        } else if (match.get(position).getHomeTeam().getName().equals("Wolverhampton Wanderers FC")) {
            holder.homeImage.setImageResource(R.drawable.wolves);
        } else if (match.get(position).getHomeTeam().getName().equals("Burnley FC")) {
            holder.homeImage.setImageResource(R.drawable.burnely);
        } else if (match.get(position).getHomeTeam().getName().equals("Leicester City FC")) {
            holder.homeImage.setImageResource(R.drawable.leicester_city);
        } else if (match.get(position).getHomeTeam().getName().equals("Southampton FC")) {
            holder.homeImage.setImageResource(R.drawable.southampton);
        } else if (match.get(position).getHomeTeam().getName().equals("Watford FC")) {
            holder.homeImage.setImageResource(R.drawable.watford);
        } else if (match.get(position).getHomeTeam().getName().equals("Crystal Palace FC")) {
            holder.homeImage.setImageResource(R.drawable.crystal_palace);
        } else if (match.get(position).getHomeTeam().getName().equals("Sheffield United FC")) {
            holder.homeImage.setImageResource(R.drawable.sheffield_united);
        } else if (match.get(position).getHomeTeam().getName().equals("Brighton & Hove Albion FC")) {
            holder.homeImage.setImageResource(R.drawable.brighton);
        } else if (match.get(position).getHomeTeam().getName().equals("West Ham United FC")) {
            holder.homeImage.setImageResource(R.drawable.west_ham);
        } else if (match.get(position).getHomeTeam().getName().equals("AFC Bournemouth")) {
            holder.homeImage.setImageResource(R.drawable.bournemonth);
        }

        if (match.get(position).getAwayTeam().getName().equals("Arsenal FC")) {
            holder.awayImage.setImageResource(R.drawable.arsenal_fc);
        } else if (match.get(position).getAwayTeam().getName().equals("Aston Villa FC")) {
            holder.awayImage.setImageResource(R.drawable.aston_villa);
        } else if (match.get(position).getAwayTeam().getName().equals("Chelsea FC")) {
            holder.awayImage.setImageResource(R.drawable.chelsea);
        } else if (match.get(position).getAwayTeam().getName().equals("Everton FC")) {
            holder.awayImage.setImageResource(R.drawable.everton);
        } else if (match.get(position).getAwayTeam().getName().equals("Liverpool FC")) {
            holder.awayImage.setImageResource(R.drawable.liverpool);
        } else if (match.get(position).getAwayTeam().getName().equals("Manchester City FC")) {
            holder.awayImage.setImageResource(R.drawable.manchester_city);
        } else if (match.get(position).getAwayTeam().getName().equals("Manchester United FC")) {
            holder.awayImage.setImageResource(R.drawable.manchester_united);
        } else if (match.get(position).getAwayTeam().getName().equals("Newcastle United FC")) {
            holder.awayImage.setImageResource(R.drawable.newcastle_united);
        } else if (match.get(position).getAwayTeam().getName().equals("Norwich City FC")) {
            holder.awayImage.setImageResource(R.drawable.norwich_city);
        } else if (match.get(position).getAwayTeam().getName().equals("Tottenham Hotspur FC")) {
            holder.awayImage.setImageResource(R.drawable.tottenham_hotspur);
        } else if (match.get(position).getAwayTeam().getName().equals("Wolverhampton Wanderers FC")) {
            holder.awayImage.setImageResource(R.drawable.wolves);
        } else if (match.get(position).getAwayTeam().getName().equals("Burnley FC")) {
            holder.awayImage.setImageResource(R.drawable.burnely);
        } else if (match.get(position).getAwayTeam().getName().equals("Leicester City FC")) {
            holder.awayImage.setImageResource(R.drawable.leicester_city);
        } else if (match.get(position).getAwayTeam().getName().equals("Southampton FC")) {
            holder.awayImage.setImageResource(R.drawable.southampton);
        } else if (match.get(position).getAwayTeam().getName().equals("Watford FC")) {
            holder.awayImage.setImageResource(R.drawable.watford);
        } else if (match.get(position).getAwayTeam().getName().equals("Crystal Palace FC")) {
            holder.awayImage.setImageResource(R.drawable.crystal_palace);
        } else if (match.get(position).getAwayTeam().getName().equals("Sheffield United FC")) {
            holder.awayImage.setImageResource(R.drawable.sheffield_united);
        } else if (match.get(position).getAwayTeam().getName().equals("Brighton & Hove Albion FC")) {
            holder.awayImage.setImageResource(R.drawable.brighton);
        } else if (match.get(position).getAwayTeam().getName().equals("West Ham United FC")) {
            holder.awayImage.setImageResource(R.drawable.west_ham);
        } else if (match.get(position).getAwayTeam().getName().equals("AFC Bournemouth")) {
            holder.awayImage.setImageResource(R.drawable.bournemonth);
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
