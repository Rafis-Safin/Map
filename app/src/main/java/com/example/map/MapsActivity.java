package com.example.map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap nMap;

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
        nMap = googleMap;
            nMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            nMap.getUiSettings().setZoomControlsEnabled(true);
            nMap.getUiSettings().setZoomGesturesEnabled(true);
            nMap.getUiSettings().setCompassEnabled(true);
        // Add a marker in Sydney and move the camera

        nMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions marker = new MarkerOptions()
                        .position(new LatLng(point.latitude, point.longitude))
                        .title("Координаты:"+point.latitude+"   "+point.longitude);
                nMap.addMarker(marker);
                System.out.println(point.latitude + "---" + point.longitude);
            }
        });







    }

    public void ChangeType(View view) {
        if(nMap.getMapType()==GoogleMap.MAP_TYPE_NORMAL){
           nMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else if(nMap.getMapType()==GoogleMap.MAP_TYPE_SATELLITE){
            nMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }
        else if(nMap.getMapType()==GoogleMap.MAP_TYPE_HYBRID){
            nMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        }
        else if(nMap.getMapType()==GoogleMap.MAP_TYPE_TERRAIN){
            nMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }










}