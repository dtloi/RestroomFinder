package com.example.cmps121bdd.restroomfinder;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class addLocationDetails extends AppCompatActivity implements View.OnClickListener{

    EditText locName;
    TextView latitude, longitude;
    Button locOpenMap;
    Button locCoor;
    CheckBox unisex;
    CheckBox handicap;
    CheckBox vendingMachine;
    private boolean mLocationPermissionGranted;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    protected static final int REQUEST_CHECK_SETTINGS = 0x1;

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
        locName = findViewById(R.id.restroom_name);
        locOpenMap = findViewById(R.id.addlocMap);
        locCoor = findViewById(R.id.getLocationBtn);
        latitude = findViewById(R.id.lat);
        longitude = findViewById(R.id.lng);

        latitude.setText(Slat);
        longitude.setText(Slng);

        locOpenMap.setOnClickListener(this);
        locCoor.setOnClickListener(this);

        unisex = findViewById(R.id.unisexBtn);
        handicap = findViewById(R.id.handicapBtn);
        vendingMachine = findViewById(R.id.vendingmachinBtn);

    }

    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.addlocMap:
                String inputLocation = locName.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("Locations");
                if (inputLocation.equals("")){
                    Toast.makeText(this,"Please input a name", Toast.LENGTH_LONG).show();
                }else {
                    myRef.child(inputLocation).child("Latitude").setValue(lat);
                    myRef.child(inputLocation).child("Longitude").setValue(lng);
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
                break;
            case R.id.getLocationBtn:
                displayCoor();
                break;
        }
    }

    public void displayCoor()
    {
        try{
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location != null) {
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();
                Toast.makeText(getApplicationContext(), "Longitude: " + longitude + "\nLatitude: " + latitude, Toast.LENGTH_SHORT).show();
            }
        }
        catch (SecurityException e)
        {
            Toast.makeText(getApplicationContext(), "Can't Add Location Without Permission", Toast.LENGTH_SHORT).show();
        }
    }

}
