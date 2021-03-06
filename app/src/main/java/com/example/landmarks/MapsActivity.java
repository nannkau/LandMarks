package com.example.landmarks;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       double x = 0;
       double y=0;

        Intent intent= getIntent();
        String name= intent.getStringExtra("data");
        switch(name){
            case "Cleveland Tower City" : {x=41.4970314;y=-81.69549517;}break;
            case  "Browns Football Field" :  {x=41.5060575;y=-81.7017368;};break;
            case  "Cleveland State University" :  {x=41.5025112;y=-81.6768155;};break;
            case  "Playhouse Square" : {x=41.5025112;y=-81.6768155;};break;
            case    "Art Museum" : {x=41.5025309;y=-81.6833816;};break;
            default:
                throw new IllegalStateException("Unexpected value: " + name);
        }
        LatLng sydney = new LatLng(x,y);
        mMap.addMarker(new MarkerOptions().position(sydney).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,18));
        MarkerOptions options= new MarkerOptions();
        options.title(name);
        options.position(sydney);
        Marker marker= mMap.addMarker(options);
        marker.showInfoWindow();
    }
}
