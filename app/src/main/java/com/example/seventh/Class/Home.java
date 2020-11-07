package com.example.seventh.Class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.seventh.Adapter.AnotherMedia;
import com.example.seventh.Adapter.EventsAdapter;
import com.example.seventh.Adapter.MediaAdapter;
import com.example.seventh.Adapter.TeamAdapter;
import com.example.seventh.Connections.Calls;
import com.example.seventh.ModelList.ListAllMedia;
import com.example.seventh.ModelList.ListLive;
import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.ModelList.ListTeam;
import com.example.seventh.R;
import com.github.islamkhsh.CardSliderViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Home extends Activity {

    private CardSliderViewPager eView;
    private static RecyclerView mView,tView;
    private TextView medBut;
    private RecyclerView.Adapter rvAdapter,mAdapter,tAdapter;
    private RecyclerView.LayoutManager rvLayout,tLayout,layout;
    private List<ListPlayers.Datum> players;
    private ProgressDialog pdLoading;
    private List<ListAllMedia.Data> lamd = new ArrayList<>();
    Calls call;
    CountDownTimer countDownTimer;
    ProgressDialog progressDialog;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        declare();
        loop();
        onClick();
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(call.loadListLive() == null || call.loadListAll() == null || call.loadListTeam() == null){
                    loop();
                }else{
                    getAll();
                    getLive();
                    getTeam();
                    pdLoading.dismiss();
                }

            }
        }.start();
    }
    public void loop(){
        startTimer();
    }

    public void declare()
    {
        call = new Calls(this);
        call.loadLive();
        call.loadAllMedia();
        call.loadAllTeams();

        medBut = findViewById(R.id.medBut);

        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        eView = findViewById(R.id.eView);
        mView = findViewById(R.id.mView);
        tView = findViewById(R.id.tView);

        //rvLayout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //eView.setLayoutManager(rvLayout);
        tLayout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mView.setLayoutManager(tLayout);
        layout = new LinearLayoutManager(this);
        tView.setLayoutManager(layout);
        /*SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(eView);*/

    }

    private void onClick()
    {
        medBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent media = new Intent(Home.this,Third.class);
                startActivity(media);
            }
        });
    }

    private void getLive()
    {
        List<ListLive.Datum> mediaModel = call.loadListLive();
        //rvAdapter = new EventsAdapter(this, mediaModel);
        eView.setAdapter(new EventsAdapter(this,mediaModel));
    }

    private void getAll()
    {
        List<ListAllMedia.Data> mediaModel = call.loadListAll();
        for(int i=0; i<3; i++){
            lamd.add(new ListAllMedia.Data(mediaModel.get(i).getTitle(),mediaModel.get(i).getSubTitle(),mediaModel.get(i).getThumbnailUrl()));
        }
        mAdapter = new AnotherMedia(this, lamd);
        mView.setAdapter(mAdapter);
    }

    private void getTeam()
    {
        List<ListTeam.Team> mediaModel = call.loadListTeam();
        tAdapter = new TeamAdapter(this, mediaModel);
        tView.setAdapter(tAdapter);
    }
}