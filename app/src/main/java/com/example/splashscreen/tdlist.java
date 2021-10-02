package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class tdlist extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
    private EditText itemET;
    private Button btn;
    private ListView itemList;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdlist);

        itemET=findViewById(R.id.eText);
        btn=findViewById(R.id.add_btn);
        itemList=findViewById(R.id.itemList);

        items=FileHelper.readData(this);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        itemList.setAdapter(adapter);


        btn.setOnClickListener(this);
        itemList.setOnItemLongClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                String itemEntered=itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelper.writeData(items,this);

                Toast.makeText(this,"Task Added",Toast.LENGTH_SHORT).show();
                break;

        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show();
        return true;
    }
}
