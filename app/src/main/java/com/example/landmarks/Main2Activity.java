package com.example.landmarks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private TextView txt;
    private Button bt2;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt= (TextView) findViewById(R.id.textViewData);
        bt2 = (Button) findViewById(R.id.button2);
        final Intent intent= getIntent();
        final String name = intent.getStringExtra("data");
        txt.setText(name);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(Main2Activity.this,MapsActivity.class);
                intent2.putExtra("data",name);
                startActivity(intent2);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url;
                switch(name){
                    case "Cleveland Tower City" : url="https://www.towercitycenter.com/";break;
                    case  "Browns Football Field" :  url="https://firstenergystadium.com/";break;
                    case  "Cleveland State University" :  url="https://www.csuohio.edu/";break;
                    case  "Playhouse Square" : url="http://www.playhousesquare.org/";break;
                    case    "Art Museum" : url="https://www.vietnamonline.com/attraction/fine-arts-museum-ho-chi-minh-city.html";break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + name);
                }
                Intent intent1=new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                startActivity(intent1);
            }
        });
    }
}
