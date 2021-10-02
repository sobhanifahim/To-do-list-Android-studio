package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExerciseList extends AppCompatActivity {
    private CircleImageView BmiImage;
    Button btn_arm,btn_leg,btn_chest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        Toolbar tlbar=findViewById(R.id.toolbarCustom_E);
        setSupportActionBar(tlbar);
        BmiImage=(CircleImageView)findViewById(R.id.bmi);
        BmiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmi=new Intent(ExerciseList.this,BmiCalculator.class);
                startActivity(bmi);


            }
        });
        btn_arm=findViewById(R.id.arm_workout);
        btn_leg=findViewById(R.id.leg_workout);
        btn_chest=findViewById(R.id.chest_workout);

        btn_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arm=new Intent(ExerciseList.this,Arm_workout.class);
                startActivity(arm);
            }
        });
        btn_chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chest=new Intent(ExerciseList.this,Chest_workout.class);
                startActivity(chest);
            }
        });
        btn_leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leg=new Intent(ExerciseList.this,Leg_workout.class);
                startActivity(leg);
            }
        });
    }
}
