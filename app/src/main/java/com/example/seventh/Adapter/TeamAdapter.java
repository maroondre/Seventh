package com.example.seventh.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.ModelList.ListTeam;
import com.example.seventh.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    public static String teamWeb;
    private Context context;
    private List<ListTeam.Team> lls;
    ListTeam.Team ls;
    Dialog myDialog;
    TextView teamTitle,teamDesc,more;
    ImageView teamImg;

    public TeamAdapter(Context context, List lls) {
        this.context = context;
        this.lls = lls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setTag(lls.get(position));
        ls = lls.get(position);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.teamsmodal);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        teamTitle = myDialog.findViewById(R.id.teamTitle);
        teamDesc = myDialog.findViewById(R.id.teamDesc);
        teamImg = myDialog.findViewById(R.id.teamImage);
        more = myDialog.findViewById(R.id.More);

        holder.teamTitle.setText(ls.getStrAlternate());
        holder.teamDesc.setText(ls.strDescriptionEN());
        Picasso.get().load(lls.get(position).getStrTeamLogo()).into(holder.teamImg);

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<lls.size(); i++){
                    if(holder.teamTitle.getText() == lls.get(i).getStrAlternate()){
                        teamTitle.setText(lls.get(i).getStrAlternate());
                        teamDesc.setText(lls.get(i).strDescriptionEN());
                        Picasso.get().load(lls.get(i).getStrTeamLogo()).into(teamImg);
                        more.setVisibility(View.GONE);
                        myDialog.show();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView teamTitle,more;
        public TextView teamDesc;
        public ImageView teamImg;

        public ViewHolder(View itemView) {
            super(itemView);

            teamTitle = (TextView) itemView.findViewById(R.id.teamTitle);
            teamDesc = (TextView) itemView.findViewById(R.id.teamDesc);
            teamImg = (ImageView) itemView.findViewById(R.id.teamImage);
            more = (TextView) itemView.findViewById(R.id.More);

        }
    }

}
