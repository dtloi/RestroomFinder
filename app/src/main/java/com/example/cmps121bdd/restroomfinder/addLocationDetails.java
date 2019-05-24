package com.example.cmps121bdd.restroomfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addLocationDetails extends AppCompatActivity{

    EditText locName;
    TextView latitude, longitude;
    Button locOpenMap;
    Button locCoor;
    CheckBox unisex, handicap, vendingMachine;
    Double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location_details);
        Intent bundle = getIntent();
        String Slat = bundle.getStringExtra("lat");
        String Slng = bundle.getStringExtra("lng");
        //Retrive user input coordinates
        lat = Double.parseDouble(Slat);
        lng = Double.parseDouble(Slng);
        //Retrive user input coordinates

        latitude = findViewById(R.id.lat);
        longitude = findViewById(R.id.lng);
        locName = findViewById(R.id.restroom_name);
        locOpenMap = findViewById(R.id.addlocMap);
        unisex = findViewById(R.id.unisexBtn);
        handicap = findViewById(R.id.handicapBtn);
        vendingMachine = findViewById(R.id.vendingmachinBtn);
        latitude.setText(Slat);
        longitude.setText(Slng);
    }

    public void addLocMap(View view) {
        String inputLocation = locName.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Locations");
        if (inputLocation.equals("")) {
            Toast.makeText(this, "Please input a name", Toast.LENGTH_LONG).show();
        } else {

            myRef.child(inputLocation).child("Latitude").setValue(lat);
            myRef.child(inputLocation).child("Longitude").setValue(lng);
            Toast.makeText(this, "Location Added!", Toast.LENGTH_LONG).show();
            finish();
        }
        if(unisex.isChecked()){
            myRef.child(inputLocation).child("Unisex").setValue(true);
        }
        else{
            myRef.child(inputLocation).child("Unisex").setValue(false);
        }
        if(handicap.isChecked()){
            myRef.child(inputLocation).child("Handicap").setValue(true);
        }
        else{
            myRef.child(inputLocation).child("Handicap").setValue(false);
        }
        if(vendingMachine.isChecked()){
            myRef.child(inputLocation).child("Vending Machine").setValue(true);
        }
        else{
            myRef.child(inputLocation).child("Vending Machine").setValue(false);
        }

    }

}

