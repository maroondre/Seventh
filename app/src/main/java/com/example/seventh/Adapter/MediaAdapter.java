package com.example.seventh.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.ModelList.ListAllMedia;
import com.example.seventh.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {

    private Context context;
    private List<ListAllMedia.Data> lam;
    private ListAllMedia.Data lm;
    Dialog myDialog;
    WebView pmView;
    TextView vidTitle;
    String vidUrl;
    Button btnExit;

    public MediaAdapter(Context context, List lam)
    {
        this.context = context;
        this.lam = lam;
    }

    @NonNull
    @Override
    public MediaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anothermedia, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MediaAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(lam.get(position));
        lm = lam.get(position);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.mediavideo);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pmView = myDialog.findViewById(R.id.pmVideo);
        vidTitle = myDialog.findViewById(R.id.vidtitle);
        btnExit = myDialog.findViewById(R.id.btnExit);

        pmView.getSettings().setJavaScriptEnabled(true);
        pmView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

        holder.title.setText(lm.getTitle());
        holder.subTitle.setText(lm.getSubTitle());
        Picasso.get().load(lm.getThumbnailUrl()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<lam.size(); i++){
                    if(holder.title.getText() == lam.get(i).getTitle()){
                        String title = lam.get(i).getTitle();
                        String url = lam.get(i).getUrl();
                        vidUrl = url.replace("watch?v=","embed/");
                        vidTitle.setText(title);
                        pmView.loadUrl(vidUrl);
                        pmView.setWebViewClient(new WebViewClient() {
                            public boolean shouldOverrideUrlLoading (WebView view, String url){
                                //True if the host application wants to leave the current WebView and handle the url itself, otherwise return false.

                                return true;
                            }
                        });

                        myDialog.show();

                        btnExit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                myDialog.dismiss();
                            }
                        });

                    }
                }
            }
        });
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
