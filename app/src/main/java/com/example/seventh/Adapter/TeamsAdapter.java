package com.example.seventh.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.Connections.Calls;
import com.example.seventh.Class.MainActivity;
import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {
    Calls call;
    private Context context;
    private List<String> llt;
    private String lt;
    public static ArrayList<ListPlayers.Datum> sortList;
    public static String teamid;
    public static Integer counter = 0;

    PlayersAdapter playersAdapter;

    public TeamsAdapter(Context context,List llt )
    {
        this.context = context;
        this.llt = llt;
        this.call = new Calls(this.context);
    }

    @NonNull
    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TeamsAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(llt.get(position));
        lt = llt.get(position);

        if (lt != null) {
            Picasso.get().load(lt).into(holder.imageImg);
        }

        sortList = call.loadListPlayers();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<ListPlayers.Datum> sortLists = new ArrayList<>();
                for (ListPlayers.Datum details : sortList) {
                    try {

                        if (details.getMainTeam().getLogo().contains(llt.get(position))) {
                            sortLists.add(details);

                            playersAdapter = new PlayersAdapter(context, sortLists);
                            MainActivity.pView.setAdapter(playersAdapter);
                            playersAdapter.notifyDataSetChanged();

                            Log.d("GetResult", details.getMainTeam().getLogo() + "-" + llt.get(position));

                        }
                    } catch (Exception e) {
                        Log.d("GetError", e.getMessage());
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return llt.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageImg = itemView.findViewById(R.id.imageID);
        }
    }


}
