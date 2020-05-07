package com.example.landmarks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView landMark;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        landMark= (ListView) findViewById(R.id.listviewLandmark);
        data = new ArrayList<>();
        data.add("Cleveland Tower City");
        data.add("Browns Football Field");
        data.add("Cleveland State University");
        data.add("Playhouse Square");
        data.add("Art Museum");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,data);
        landMark.setAdapter(adapter);
        landMark.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                Toast.makeText(MainActivity.this,data.get(position),Toast.LENGTH_SHORT).show();
                intent.putExtra("data",data.get(position));
                startActivity(intent);
            }



        });

    }

}
