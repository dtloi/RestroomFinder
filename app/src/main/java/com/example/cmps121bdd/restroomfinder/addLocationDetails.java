package com.example.cmps121bdd.restroomfinder;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class addLocationDetails extends AppCompatActivity implements View.OnClickListener{

    EditText locName;
    Button locOpenMap;
    Button locCoor;
    String tg = "addLocationDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_location_details);

        locName = findViewById(R.id.restroom_name);
        locOpenMap = findViewById(R.id.addlocMap);
        locCoor = findViewById(R.id.getLocationBtn);

        locOpenMap.setOnClickListener(this);
        locCoor.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.addlocMap:
                String location = locName.getText().toString();
                if (location.equals("")){
                    Toast.makeText(this,"Please input a name", Toast.LENGTH_LONG).show();
                    break;
                }else {
                    Intent intent1 = new Intent(this, newLocation.class);    //Creating intent to pass to MapActivity
                    intent1.putExtra("location", location);                    //Adding user input to intent
                    startActivity(intent1);
                    finish();
                    break;
                }
            case R.id.getLocationBtn:
                /*Location location1 = FindCoor.displayCoor();
                if(location1 != null)
                    Toast.makeText(getApplicationContext(), "Longitude: " + location1.getLongitude()
                            + "\nLatitude: " + location1.getLatitude(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "No Location" + location1.getLatitude(), Toast.LENGTH_SHORT).show();*/
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
            e.printStackTrace();
            Log.e(tg, "Security Exception: "+ e);
        }
    }
}
