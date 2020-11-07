package com.example.seventh.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.ModelList.ListAllMedia;
import com.example.seventh.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnotherMedia extends RecyclerView.Adapter<AnotherMedia.ViewHolder> {

    private Context context;
    private List<ListAllMedia.Data> lam;
    private ListAllMedia.Data lm;

    public AnotherMedia(Context context, List lam)
    {
    this.context = context;
    this.lam = lam;
    }

    @NonNull
    @Override
    public AnotherMedia.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.media, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnotherMedia.ViewHolder holder, int position) {
        holder.itemView.setTag(lam.get(position));
        lm = lam.get(position);

        holder.title.setText(lm.getTitle());
        holder.subTitle.setText(lm.getSubTitle());
        Picasso.get().load(lm.getThumbnailUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
    return lam.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,subTitle;
        Button btnWatch;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subtitle);
            //btnWatch = itemView.findViewById(R.id.watch);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
