package com.example.dubstep;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RiderMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double Rider_Lat;
    private double Rider_Long;
    private double Order_Lat;
    private double Order_Long;
    private double Distance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Rider_Lat = Double.parseDouble(getIntent().getStringExtra("RiderLat"));
        Rider_Long = Double.parseDouble(getIntent().getStringExtra("RiderLong")) ;
        Order_Lat = Double.parseDouble(getIntent().getStringExtra("OrderLat"));
        Order_Long = Double.parseDouble(getIntent().getStringExtra("OrderLong"));
        Distance = Double.parseDouble(getIntent().getStringExtra("Distance"));

        //Toast.makeText(RiderMapsActivity.this,""+Distance,Toast.LENGTH_SHORT).show();

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
        LatLng order = new LatLng(Order_Lat, Order_Long);
        LatLng rider = new LatLng(Rider_Lat, Rider_Long);
        mMap.addMarker(new MarkerOptions().position(order).title("Order Location").icon(BitmapDescriptorFactory.defaultMarker(150)));
        mMap.addMarker(new MarkerOptions().position(rider).title("Rider Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(order));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        //Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
         //      Uri.parse("http://maps.google.com/maps?saddr="+Double.toString(Rider_Lat)+","+Double.toString(Rider_Long)+"&daddr="+Double.toString(Order_Lat)+","+Double.toString(Order_Long)));
        //startActivity(intent);
    }
}
