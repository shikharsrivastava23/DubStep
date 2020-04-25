package com.example.dubstep.ViewHolder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dubstep.LoginActivity;
import com.example.dubstep.MainActivity;
import com.example.dubstep.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThankYouActivity extends AppCompatActivity {

    DatabaseReference orderref;
    Button ContinueButton;
    String UID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        ContinueButton = findViewById(R.id.ContinueButton);
        UID = getIntent().getStringExtra("UID");

        orderref = FirebaseDatabase.getInstance().getReference().child("Orders");

        ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderref.child(UID).removeValue();
                startActivity(new Intent(ThankYouActivity.this, LoginActivity.class));

            }
        });
    }
}
