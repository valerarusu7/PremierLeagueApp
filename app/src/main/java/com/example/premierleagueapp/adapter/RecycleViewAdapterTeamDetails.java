package com.example.premierleagueapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premierleagueapp.R;
import com.example.premierleagueapp.model.Player;
import com.example.premierleagueapp.model.Team;

import java.util.ArrayList;

public class RecycleViewAdapterTeamDetails extends RecyclerView.Adapter<RecycleViewAdapterTeamDetails.ViewHolder> {
    private Team team;
    private ArrayList<Player> squad;

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
        holder.name.setText(squad.get(position).getName());
        holder.nationality.setText(squad.get(position).getNationality());
        holder.number.setText(String.valueOf(team.getSquad().get(position).getShirtNumber()));
        holder.position.setText(squad.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        if (squad != null) {
            return squad.size();
        }
        return 0;
    }

    public void setTeam(Team team) {
        this.team = team;
        this.squad = team.getSquad();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView number;
        TextView position;
        TextView name;
        TextView nationality;
        TextView teamName;
        TextView shortName;
        TextView tla;
        TextView address;
        TextView phone;
        TextView website;
        TextView email;
        TextView founded;
        TextView clubColors;
        TextView venue;
        LinearLayout linearLayout;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.player_number);
            position = itemView.findViewById(R.id.player_position);
            name = itemView.findViewById(R.id.player_name);
            nationality = itemView.findViewById(R.id.player_nationality);
            parentLayout = itemView.findViewById(R.id.player_item_layout);
            teamName = itemView.findViewById(R.id.teamName);
            shortName = itemView.findViewById(R.id.shortName);
            tla = itemView.findViewById(R.id.tla);
            address = itemView.findViewById(R.id.address);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
            email = itemView.findViewById(R.id.email);
            founded = itemView.findViewById(R.id.founded);
            clubColors = itemView.findViewById(R.id.clubColors);
            venue = itemView.findViewById(R.id.venue);
            linearLayout = itemView.findViewById(R.id.teamActivity);

        }
    }

}
