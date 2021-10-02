package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class calculateBills extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,btnadd,btnsub,btnmul,btndiv,btnclr,btneql;

    EditText editText;
    float res1,res2;
    boolean Add,Sub,Mul,Div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bills);
        btn1=(Button)findViewById(R.id._1);
        btn2=(Button)findViewById(R.id._2);
        btn3=(Button)findViewById(R.id._3);
        btn4=(Button)findViewById(R.id._4);
        btn5=(Button)findViewById(R.id._5);
        btn6=(Button)findViewById(R.id._6);
        btn7=(Button)findViewById(R.id._7);
        btn8=(Button)findViewById(R.id._8);
        btn9=(Button)findViewById(R.id._9);
        btn0=(Button)findViewById(R.id._0);
        btndot=(Button)findViewById(R.id.dot);
        btnadd=(Button)findViewById(R.id.add);
        btnsub=(Button)findViewById(R.id.sub);
        btnmul=(Button)findViewById(R.id.mul);
        btndiv=(Button)findViewById(R.id.div);
        btnclr=(Button)findViewById(R.id.clear);
        btneql=(Button)findViewById(R.id.equal);
        editText=(EditText)findViewById(R.id.ed1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"0");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+".");
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText==null){
                    editText.setText("");
                }
                else{
                    res1=Float.parseFloat(editText.getText()+"");
                    Add=true;
                    editText.setText(null);
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText==null){
                    editText.setText("");
                }
                else{
                    res1=Float.parseFloat(editText.getText()+"");
                    Sub=true;
                    editText.setText(null);
                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText==null){
                    editText.setText("");
                }
                else{
                    res1=Float.parseFloat(editText.getText()+"");
                    Mul=true;
                    editText.setText(null);
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText==null){
                    editText.setText("");
                }
                else{
                    res1=Float.parseFloat(editText.getText()+"");
                    Div=true;
                    editText.setText(null);
                }
            }
        });
        btneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res2=Float.parseFloat(editText.getText()+"");
                if(Add==true){
                    editText.setText(res1+res2+"");
                    Add=false;
                }
                if(Sub==true){
                    editText.setText(res1-res2+"");
                    Sub=false;
                }
                if(Mul==true){
                    editText.setText(res1*res2+"");
                    Mul=false;
                }
                if(Div==true){
                    editText.setText(res1/res2+"");
                    Div=false;
                }
            }
        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });




    }
}
