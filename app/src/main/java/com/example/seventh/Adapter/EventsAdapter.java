package com.example.seventh.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.ModelList.ListLive;
import com.example.seventh.R;
import com.github.islamkhsh.CardSliderAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends CardSliderAdapter<EventsAdapter.ViewHolder> {

    private Context context;
    private ListLive.Datum lv;
    private List<ListLive.Datum> lvd;

    public EventsAdapter(Context context, List lvd)
    {
        this.context = context;
        this.lvd = lvd;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void bindVH(@NonNull EventsAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(lvd.get(position));
        lv = lvd.get(position);

        if(lv.getSeason() != null)
        {
            holder.league.setText(lv.getSeason().getName());
        }

        holder.date.setText(lv.getStartAt());
        holder.status.setText(lv.getStatus());
        // holder.time.setText(lv.getMatchTime());
        holder.home.setText(lv.getHomeTeam().getName());
        holder.away.setText(lv.getAwayTeam().getName());
        holder.homeScore.setText(lv.getHomeScore().getDisplay().toString());
        holder.awayScore.setText(lv.getAwayScore().getDisplay().toString());
        Picasso.get().load(lvd.get(position).getHomeTeam().getLogo()).into(holder.homeImg);
        Picasso.get().load(lvd.get(position).getAwayTeam().getLogo()).into(holder.awayImg);
        //Picasso.get().load(lvd.get(position).getCountryLogo()).into(holder.countryImg);

    }

    @Override
    public int getItemCount() {
        return lvd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView country,league,date,status,time, home, away, homeScore, awayScore;
        public ImageView homeImg, awayImg, countryImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.country);
            league = itemView.findViewById(R.id.league);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            time = itemView.findViewById(R.id.time);
            home = itemView.findViewById(R.id.home);
            away = itemView.findViewById(R.id.away);
            homeScore = itemView.findViewById(R.id.homeScore);
            awayScore = itemView.findViewById(R.id.awayScore);
            homeImg = itemView.findViewById(R.id.homeImg);
            awayImg = itemView.findViewById(R.id.awayImg);
            countryImg = itemView.findViewById(R.id.countryImg);

        }
    }
}
