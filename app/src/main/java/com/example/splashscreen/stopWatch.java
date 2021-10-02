package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class stopWatch extends AppCompatActivity {
     private Chronometer chronometer;
     private boolean running;
     private long pO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        chronometer = findViewById(R.id.choronometer);
        chronometer.setFormat("Time: %");
        chronometer.setBase(SystemClock.elapsedRealtime());


    }
        public void startChronometer(View v) {
            if (!running) {
                chronometer.setBase(SystemClock.elapsedRealtime() - pO);
                chronometer.start();
                running = true;
            }
        }
        public void pauseChronometer(View v) {
            if (running) {
                chronometer.stop();
                pO = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
            }
        }
        public void resetChronometer(View v) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pO = 0;
        }
}
