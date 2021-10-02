package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BmiCalculator extends AppCompatActivity {
    private EditText weight, height;
    private TextView resultText;
    private String calcultaion, BMIresult, s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resultText = findViewById(R.id.result);


    }
    public void calculateBMI(View view){

        s1 = weight.getText().toString();
        s2 = height.getText().toString();


       if(s1!=null && !"".equals(s1) && s2!=null && !"".equals(s2)) {
           float weightValue = Float.parseFloat(s1);
           float heightValue = Float.parseFloat(s2) / 100;


           float bmi = weightValue / (heightValue * heightValue);

           if (bmi < 16) {
               BMIresult = "Severaly Under Weight";
           } else if (bmi < 18.5) {
               BMIresult = "Under Weight";
           } else if (bmi >= 18.5 && bmi <= 24.9) {
               BMIresult = "Normal Weight";
           } else if (bmi >= 25 && bmi <= 29.9) {
               BMIresult = "Over Weight";
           } else {
               BMIresult = "Obese";
           }

           calcultaion = "                        " + bmi + "\n                        " + BMIresult;
           resultText.setText(calcultaion);
       }
       else{
           Toast.makeText(this,"Enter Value",Toast.LENGTH_SHORT).show();
       }



    }
}
