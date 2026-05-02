package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityPlanets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_planets);
    }
    public void openT(View view) {
        Intent intent = new Intent(this, MainActivityTerrestrial.class);
        startActivity(intent);
    }
    public void openG(View view){
        Intent intent = new Intent(this, MainActivityGasGiants.class);
        startActivity(intent);
    }
    public void openI(View view){
        Intent intent = new Intent(this, MainActivityIceGiants.class);
        startActivity(intent);
    }
    public void openC(View view){
        Intent intent = new Intent(this, MainActivityCelestial.class);
        startActivity(intent);
    }
}