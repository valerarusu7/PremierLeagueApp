package com.example.premierleagueapp.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import java.util.concurrent.ExecutionException;

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

        if(teamsNames.get(position).getName().equals("Arsenal FC")) {
            holder.imageView.setImageResource(R.drawable.arsenal_fc);
        } else if(teamsNames.get(position).getName().equals("Aston Villa FC")) {
            holder.imageView.setImageResource(R.drawable.aston_villa);
        } else if(teamsNames.get(position).getName().equals("Chelsea FC")) {
            holder.imageView.setImageResource(R.drawable.chelsea);
        } else if(teamsNames.get(position).getName().equals("Everton FC")) {
            holder.imageView.setImageResource(R.drawable.everton);
        } else if(teamsNames.get(position).getName().equals("Liverpool FC")) {
            holder.imageView.setImageResource(R.drawable.liverpool);
        } else if(teamsNames.get(position).getName().equals("Manchester City FC")) {
            holder.imageView.setImageResource(R.drawable.manchester_city);
        } else if(teamsNames.get(position).getName().equals("Manchester United FC")) {
            holder.imageView.setImageResource(R.drawable.manchester_united);
        } else if(teamsNames.get(position).getName().equals("Newcastle United FC")) {
            holder.imageView.setImageResource(R.drawable.newcastle_united);
        } else if(teamsNames.get(position).getName().equals("Norwich City FC")) {
            holder.imageView.setImageResource(R.drawable.norwich_city);
        } else if(teamsNames.get(position).getName().equals("Tottenham Hotspur FC")) {
            holder.imageView.setImageResource(R.drawable.tottenham_hotspur);
        } else if(teamsNames.get(position).getName().equals("Wolverhampton Wanderers FC")) {
            holder.imageView.setImageResource(R.drawable.wolves);
        } else if(teamsNames.get(position).getName().equals("Burnley FC")) {
            holder.imageView.setImageResource(R.drawable.burnely);
        } else if(teamsNames.get(position).getName().equals("Leicester City FC")) {
            holder.imageView.setImageResource(R.drawable.leicester_city);
        } else if(teamsNames.get(position).getName().equals("Southampton FC")) {
            holder.imageView.setImageResource(R.drawable.southampton);
        } else if(teamsNames.get(position).getName().equals("Watford FC")) {
            holder.imageView.setImageResource(R.drawable.watford);
        } else if(teamsNames.get(position).getName().equals("Crystal Palace FC")) {
            holder.imageView.setImageResource(R.drawable.crystal_palace);
        } else if(teamsNames.get(position).getName().equals("Sheffield United FC")) {
            holder.imageView.setImageResource(R.drawable.sheffield_united);
        } else if(teamsNames.get(position).getName().equals("Brighton & Hove Albion FC")) {
            holder.imageView.setImageResource(R.drawable.brighton);
        } else if(teamsNames.get(position).getName().equals("West Ham United FC")) {
            holder.imageView.setImageResource(R.drawable.west_ham);
        } else if(teamsNames.get(position).getName().equals("AFC Bournemouth")) {
            holder.imageView.setImageResource(R.drawable.bournemonth);
        }
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
