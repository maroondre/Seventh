package com.example.seventh.Adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder> {

    private Context context;
    public static List<ListPlayers.Datum> llp;
    private SparseBooleanArray expandState = new SparseBooleanArray();
    private ListPlayers.Datum lp;
    private onClickItem onClickItem;
    int get;

    public PlayersAdapter(Context context, List llp)
    {
        this.context = context;
        this.llp = llp;
    }


    @NonNull
    @Override
    public PlayersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PlayersAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(llp.get(position));
        lp = llp.get(position);

        if(lp.getMainTeam() != null){
            holder.playerteam.setText(lp.getMainTeam().getName());
            holder.teamteam.setText(lp.getMainTeam().getName());
            Picasso.get().load(lp.getMainTeam().getLogo()).into(holder.teamimg);
        }


        holder.playername.setText(lp.getName());
        Picasso.get().load(lp.getPhoto()).into(holder.playerimg);
        Picasso.get().load(lp.getPhoto()).into(holder.imagetwo);
        holder.playertwo.setText(lp.getName());

        holder.shirtnumber.setText("#"+nullable(lp.getShirtNumber()));
        holder.rating.setText(nullable(lp.getRating()));
        holder.age.setText(nullable(lp.getAge()));
        holder.weight.setText(nullable(lp.getWeight()+"kg"));
        holder.height.setText(nullable(lp.getHeight()+"cm"));

        holder.expandableLayout.setVisibility(View.GONE);
        holder.viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < llp.size(); i++){
                    if(llp.get(position) == llp.get(i)){
                        //get = holder.getBindingAdapterPosition();
                        holder.first.setVisibility(View.GONE);
                        holder.expandableLayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.first.setVisibility(View.VISIBLE);
                holder.expandableLayout.setVisibility(View.GONE);
            }
        });
    }

    public void refreshRV(ArrayList<ListPlayers.Datum> llt){
        llp = llt;

        Toast.makeText(context, "HEEE", Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();


    }

    private interface onClickItem{

    }

    public String nullable(String object){
        object = (object == null) ?  "" : object;
        return object;
    }
    public String nullable(Integer object){
        object = (object == null) ?  0 : object;
        return object.toString();
    }
    public String nullable(Float object){
        object = (object == null) ?  0 : object;
        return object.toString();
    }


    @Override
    public int getItemCount() {
        return llp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView playerimg, imagetwo, teamimg;
        TextView playername,viewmore,playerteam,playertwo,teamteam;
        TextView shirtnumber, rating,age,weight,height;
        LinearLayout expandableLayout,first;
        RelativeLayout button;
        View arrowup;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.buttonplayer);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            first = itemView.findViewById(R.id.first);

            playerimg = itemView.findViewById(R.id.playerImg);
            imagetwo = itemView.findViewById(R.id.imageTwo);
            teamimg = itemView.findViewById(R.id.teamImg);
            playername = itemView.findViewById(R.id.playername);
            viewmore = itemView.findViewById(R.id.viewMore);
            playerteam = itemView.findViewById(R.id.playerTeam);
            playertwo = itemView.findViewById(R.id.playerTwo);
            shirtnumber = itemView.findViewById(R.id.shirtNumber);
            rating = itemView.findViewById(R.id.rating);
            age = itemView.findViewById(R.id.age);
            weight = itemView.findViewById(R.id.weight);
            height = itemView.findViewById(R.id.height);
            teamteam = itemView.findViewById(R.id.teamteam);
            arrowup = itemView.findViewById(R.id.arrowplayer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(expandableLayout.getVisibility() == View.GONE){
                        first.setVisibility(View.GONE);
                        expandableLayout.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}
