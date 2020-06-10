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
import com.example.premierleagueapp.model.Table;

import java.util.ArrayList;

public class RecyclerViewAdapterTable extends RecyclerView.Adapter<RecyclerViewAdapterTable.ViewHolder> {

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
        Glide.with(holder.emblem).load(tables.get(position).getTeam().getCrestUrl()).into(holder.emblem);

    }

    @Override
    public int getItemCount() {
        if (tables != null) {
            return tables.size();
        }
        return 0;
    }

    public void setTable(ArrayList<Table> tables) {
        this.tables = tables;
        notifyDataSetChanged();
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

}
