package com.example.splashscreen;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;


public class Dashboard extends AppCompatActivity {

    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE=1;
    Uri imageUri;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn1=(Button)findViewById(R.id.btn_one);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1= new Intent(Dashboard.this,tdlist.class);
                startActivity(in1);
            }
        });
        btn2=(Button)findViewById(R.id.btn_two);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2=new Intent(Dashboard.this,ExerciseList.class);
                startActivity(in2);
            }
        });
        btn3=(Button)findViewById(R.id.btn_three);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3=new Intent(Dashboard.this,calculateBills.class);
                startActivity(in3);
            }
        });
        btn4=(Button)findViewById(R.id.btn_four);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in4=new Intent(Dashboard.this,setReminder.class);
                startActivity(in4);
            }
        });
        btn5=(Button)findViewById(R.id.btn_five);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in5=new Intent(Dashboard.this,footStep.class);
                startActivity(in5);
            }
        });
        btn6=(Button)findViewById(R.id.btn_six);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in6=new Intent(Dashboard.this,stopWatch.class);
                startActivity(in6);
            }
        });

        Toolbar toolbar=findViewById(R.id.toolbarCustom);
        setSupportActionBar(toolbar);

        ProfileImage=(CircleImageView)findViewById(R.id.Profile_Image);
        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent gallery = new Intent();
                    gallery.setType("image/*");
                    gallery.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            imageUri=data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                ProfileImage.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
