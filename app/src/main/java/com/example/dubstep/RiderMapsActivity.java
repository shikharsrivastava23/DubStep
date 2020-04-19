package com.example.dubstep;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RiderMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double Rider_Lat;
    private double Rider_Long;
    private double Order_Lat;
    private double Order_Long;
    private double Distance;
    private String Customer_phone;
    private String Customer_UID;
    private String status;
    private String Amount;

    DatabaseReference OrderNodeRef;

    TextView PhoneNumberTextView, AmountTextView, DistanceTextView;


    private MaterialButton maccept;
    private MaterialButton mDelivered;
    private MaterialButton mStartNav;


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
        Customer_phone = getIntent().getStringExtra("Phone_Number");
        Customer_UID = getIntent().getStringExtra("Customer_UID");
        status = getIntent().getStringExtra("Status");
        Amount = getIntent().getStringExtra("Amount");

        PhoneNumberTextView = findViewById(R.id.PhoneNumber_TextView);
        AmountTextView = findViewById(R.id.Amount_TextView);
        DistanceTextView = findViewById(R.id.Distance_TextView);

        PhoneNumberTextView.setText(Customer_phone);
        AmountTextView.setText("Amount = "+Amount);
        DistanceTextView.setText("Distance : "+String.format("%.2f",Distance)+" Km");

        //Toast.makeText(RiderMapsActivity.this,""+Distance,Toast.LENGTH_SHORT).show();

        maccept = findViewById(R.id.ActionButton);
        mDelivered = findViewById(R.id.ActionButton2);
        mStartNav = findViewById(R.id.NavigationButton);

        OrderNodeRef = FirebaseDatabase.getInstance().getReference().child("Orders");

        maccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maccept.setVisibility(View.GONE);
                mDelivered.setVisibility(View.VISIBLE);
                mStartNav.setVisibility(View.VISIBLE);

                OrderNodeRef.child(Customer_UID).child("Status").setValue("1");



            }
        });

        mDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RiderMapsActivity.this,"ORDER DELIVERED!",Toast.LENGTH_SHORT).show();
                OrderNodeRef.child(Customer_UID).child("Status").setValue("2");
            }
        });

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

        mStartNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr="+Double.toString(Rider_Lat)+","+Double.toString(Rider_Long)+"&daddr="+Double.toString(Order_Lat)+","+Double.toString(Order_Long)));
                startActivity(intent);
            }
        });


    }
}
