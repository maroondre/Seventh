package com.example.seventh.Class;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.seventh.Adapter.MediaAdapter;
import com.example.seventh.Connections.Calls;
import com.example.seventh.ModelList.ListAllMedia;
import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class Third extends Activity {

    public static RecyclerView mView;
    public static RecyclerView tView;
    private RecyclerView.Adapter rvAdapter,tAdapter;
    private RecyclerView.LayoutManager rvLayout,tLayout;
    private List<ListPlayers.Datum> players;
    private ProgressDialog pdLoading;
    private BottomNavigationView bottomNavigationView;
    Calls call;
    CardView card;
    CountDownTimer countDownTimer;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
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
                if(call.loadListAll() == null){
                    loop();
                }else{
                    getAll();
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
        call.loadAllMedia();
        pdLoading = new ProgressDialog(this);
        pdLoading.setMessage("\tPlease Wait...");
        pdLoading.setCancelable(false);
        pdLoading.show();
//        card = findViewById(R.id.mediaCard);
//        card.setLayoutParams(new RelativeLayout.LayoutParams(400,150));
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.three);
        mView = findViewById(R.id.thirdView);
        rvLayout = new LinearLayoutManager(this);
        mView.setLayoutManager(rvLayout);



    }

    private void getAll()
    {
        List<ListAllMedia.Data> mediaModel = call.loadListAll();
        tAdapter = new MediaAdapter(this, mediaModel);
        mView.setAdapter(tAdapter);
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