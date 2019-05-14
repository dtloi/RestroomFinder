package com.example.cmps121bdd.restroomfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addLocationDetails extends AppCompatActivity implements View.OnClickListener {

    EditText locName;
    Button locOpenMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location_details);

        locName = findViewById(R.id.restroom_name);
        locOpenMap = findViewById(R.id.addlocMap);

        locOpenMap.setOnClickListener(this);
    }

    public void onClick(View view) {
        String location = locName.getText().toString();
        if (location.equals("")){
            Toast.makeText(this,"Please input a name", Toast.LENGTH_LONG).show();
        }else{
            Intent intent1 = new Intent (this, newLocation.class);    //Creating intent to pass to MapActivity
            intent1.putExtra("location",location);                    //Adding user input to intent
            startActivity(intent1);
            finish();
        }

    }
}
