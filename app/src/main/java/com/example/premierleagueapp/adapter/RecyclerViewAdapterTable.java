package com.example.premierleagueapp.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Table;

import java.util.ArrayList;

public class RecyclerViewAdapterTable extends RecyclerView.Adapter<RecyclerViewAdapterTable.ViewHolder>{

    private ArrayList<Table> tables;
    private OnListItemClickListener mOnListItemClickListener;

    public RecyclerViewAdapterTable(ArrayList<Table> tables, OnListItemClickListener listener) {
        this.tables = tables;
        mOnListItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_row_item, parent, false);
        return new ViewHolder(view, mOnListItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapterTable.ViewHolder holder, final int position) {

        holder.position.setText(String.valueOf(tables.get(position).getPosition()));
        holder.club.setText(tables.get(position).getTeam().getName());
        holder.playedGames.setText(String.valueOf(tables.get(position).getPlayedGames()));
        holder.wonGames.setText(String.valueOf(tables.get(position).getWon()));
        holder.drawGames.setText(String.valueOf(tables.get(position).getDraw()));
        holder.lostGames.setText(String.valueOf(tables.get(position).getLost()));
        holder.goalDifference.setText(String.valueOf(tables.get(position).getGoalDifference()));
        holder.points.setText(String.valueOf(tables.get(position).getPoints()));

        if(tables.get(position).getTeam().getName().equals("Arsenal FC")) {
            holder.emblem.setImageResource(R.drawable.arsenal_fc);
        } else if(tables.get(position).getTeam().getName().equals("Aston Villa FC")) {
            holder.emblem.setImageResource(R.drawable.aston_villa);
        } else if(tables.get(position).getTeam().getName().equals("Chelsea FC")) {
            holder.emblem.setImageResource(R.drawable.chelsea);
        } else if(tables.get(position).getTeam().getName().equals("Everton FC")) {
            holder.emblem.setImageResource(R.drawable.everton);
        } else if(tables.get(position).getTeam().getName().equals("Liverpool FC")) {
            holder.emblem.setImageResource(R.drawable.liverpool);
        } else if(tables.get(position).getTeam().getName().equals("Manchester City FC")) {
            holder.emblem.setImageResource(R.drawable.manchester_city);
        } else if(tables.get(position).getTeam().getName().equals("Manchester United FC")) {
            holder.emblem.setImageResource(R.drawable.manchester_united);
        } else if(tables.get(position).getTeam().getName().equals("Newcastle United FC")) {
            holder.emblem.setImageResource(R.drawable.newcastle_united);
        } else if(tables.get(position).getTeam().getName().equals("Norwich City FC")) {
            holder.emblem.setImageResource(R.drawable.norwich_city);
        } else if(tables.get(position).getTeam().getName().equals("Tottenham Hotspur FC")) {
            holder.emblem.setImageResource(R.drawable.tottenham_hotspur);
        } else if(tables.get(position).getTeam().getName().equals("Wolverhampton Wanderers FC")) {
            holder.emblem.setImageResource(R.drawable.wolves);
        } else if(tables.get(position).getTeam().getName().equals("Burnley FC")) {
            holder.emblem.setImageResource(R.drawable.burnely);
        } else if(tables.get(position).getTeam().getName().equals("Leicester City FC")) {
            holder.emblem.setImageResource(R.drawable.leicester_city);
        } else if(tables.get(position).getTeam().getName().equals("Southampton FC")) {
            holder.emblem.setImageResource(R.drawable.southampton);
        } else if(tables.get(position).getTeam().getName().equals("Watford FC")) {
            holder.emblem.setImageResource(R.drawable.watford);
        } else if(tables.get(position).getTeam().getName().equals("Crystal Palace FC")) {
            holder.emblem.setImageResource(R.drawable.crystal_palace);
        } else if(tables.get(position).getTeam().getName().equals("Sheffield United FC")) {
            holder.emblem.setImageResource(R.drawable.sheffield_united);
        } else if(tables.get(position).getTeam().getName().equals("Brighton & Hove Albion FC")) {
            holder.emblem.setImageResource(R.drawable.brighton);
        } else if(tables.get(position).getTeam().getName().equals("West Ham United FC")) {
            holder.emblem.setImageResource(R.drawable.west_ham);
        } else if(tables.get(position).getTeam().getName().equals("AFC Bournemouth")) {
            holder.emblem.setImageResource(R.drawable.bournemonth);
        }
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView position;
        TextView club;
        TextView playedGames;
        TextView wonGames;
        TextView drawGames;
        TextView lostGames;
        TextView goalDifference;
        TextView points;
        ImageView emblem;

        RelativeLayout parentLayout;
        OnListItemClickListener onListItemClickListener;

        public ViewHolder(@NonNull View itemView, OnListItemClickListener listener) {
            super(itemView);

            position = itemView.findViewById(R.id.position);
            emblem = itemView.findViewById(R.id.emblem);
            club = itemView.findViewById(R.id.club);
            playedGames = itemView.findViewById(R.id.playedGames);
            wonGames = itemView.findViewById(R.id.wonGames);
            drawGames = itemView.findViewById(R.id.drawGames);
            lostGames = itemView.findViewById(R.id.lostGames);
            goalDifference = itemView.findViewById(R.id.goalDifference);
            points = itemView.findViewById(R.id.points);
            parentLayout = itemView.findViewById(R.id.recycler_view_table);

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
