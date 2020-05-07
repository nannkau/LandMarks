package com.example.landmarks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt= (TextView) findViewById(R.id.textViewData);
        Intent intent= getIntent();
        String name = intent.getStringExtra("data");
        txt.setText(name);
    }
}
