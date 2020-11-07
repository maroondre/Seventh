package com.example.seventh.Class;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;

import com.example.seventh.Adapter.EventsAdapter;
import com.example.seventh.Adapter.EventsLive;
import com.example.seventh.Adapter.PlayersAdapter;
import com.example.seventh.Connections.Calls;
import com.example.seventh.ModelList.ListLive;
import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class LiveEvents extends Activity {

    public static RecyclerView pView;
    public static RecyclerView tView;
    private RecyclerView.Adapter rvAdapter,tAdapter;
    private RecyclerView.LayoutManager rvLayout,tLayout;
    private List<ListPlayers.Datum> players;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    Calls call;
    CountDownTimer countDownTimer;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_events);
        declare();
        loop();
        navBottom();
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(call.loadListLive() == null){
                    loop();
                }else{

                   getLive();
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
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.two);
        pView = findViewById(R.id.liveView);
        rvLayout = new LinearLayoutManager(this);
        pView.setLayoutManager(rvLayout);

    }

    private void getLive()
    {
        List<ListLive.Datum> mediaModel = call.loadListLive();
        rvAdapter = new EventsLive(this, mediaModel);
        pView.setAdapter(rvAdapter);
    }

    private void navBottom()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.one:
                        Intent main = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(main);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.two:
                        Intent live = new Intent(getApplicationContext(), LiveEvents.class);
                        startActivity(live);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.three:
                        Intent third = new Intent(getApplicationContext(), Third.class);
                        startActivity(third);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.four:
                        Intent home = new Intent(getApplicationContext(), Home.class);
                        startActivity(home);
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }
        });
    }
}