package com.example.premierleagueapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Team;

public class RecycleViewAdapterTeamDetails extends RecyclerView.Adapter<RecycleViewAdapterTeamDetails.ViewHolder>{
    private Team team;

    public RecycleViewAdapterTeamDetails() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(team.getSquad().get(position).getName());
        holder.nationality.setText(team.getSquad().get(position).getNationality());
//        holder.number.setText(String.valueOf(team.getSquad().get(position).getShirtNumber()));
        holder.position.setText(team.getSquad().get(position).getPosition());

    }

    @Override
    public int getItemCount() {
        if(team.getSquad() != null) {
            return team.getSquad().size();
        }
        return 0;
    }

    public void setTeam(Team team) {
        this.team = team;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView number;
        TextView position;
        TextView name;
        TextView nationality;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.player_number);
            position = itemView.findViewById(R.id.player_position);
            name = itemView.findViewById(R.id.player_name);
            nationality = itemView.findViewById(R.id.player_nationality);
            parentLayout = itemView.findViewById(R.id.player_item_layout);

        }
    }

}
