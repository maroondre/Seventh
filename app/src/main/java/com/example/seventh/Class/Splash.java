package com.example.seventh.Class;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import com.example.seventh.Connections.Calls;
import com.example.seventh.R;
import com.kaiguanjs.SplashLietener;
import com.kaiguanjs.utils.YQCUtils;

public class Splash extends Activity {

    Handler handler;
    Calls calls;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        calls = new Calls(this);
        handler=new Handler();

        YQCUtils.splashAction(this, new SplashLietener() {
            @Override
            public void startMySplash(int version, String downUrl) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        calls.clearData();
                        calls.loadAllMedia();
                        calls.loadTeams();
                        calls.loadPlayers();
                        calls.loadAllTeams();
                        Intent intent=new Intent(Splash.this, Home.class);
                        startActivity(intent);
                        finish();
                    }
                },6000);
            }
        });


    }
}