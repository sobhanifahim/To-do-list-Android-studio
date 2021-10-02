package com.example.splashscreen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class footStep extends AppCompatActivity implements SensorEventListener {


    TextView textView;
    Button reset;
    ProgressBar progressBar;
    int totalsteps=0;
    String restart;
    SensorManager sensorManager;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_step);
        textView=findViewById(R.id.steptaken);
        progressBar=findViewById(R.id.progress_bar);
        reset=(Button)findViewById(R.id.toz);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        reset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StringFormatInvalid")
            @Override
            public void onClick(View v) {
                totalsteps=0;
                textView.setText(totalsteps);
                progressBar.setProgress(0);



            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countsensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countsensor == null){
            Toast.makeText(this,"sensor not found!",Toast.LENGTH_SHORT).show();
        }
        else{
            sensorManager.registerListener(this,countsensor,sensorManager.SENSOR_DELAY_FASTEST);
        }

    }



    @Override
    protected void onPause() {
        super.onPause();
        running=false;
        sensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

           if(running){
                textView.setText(String.valueOf(event.values[0]));
                totalsteps=(int)event.values[0];
                progressBar.setMax(10000);
                progressBar.setProgress(totalsteps);


           }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {



    }





}
