package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityCelestial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_celestial);
    }
    public void openSun(View view){
        Intent intent = new Intent(this, MainActivitySun.class);
        startActivity(intent);
    }
    public void openPluto(View view){
        Intent intent = new Intent(this, MainActivityPluto.class);
        startActivity(intent);
    }
    public void openAsteroidBelt(View view){
        Intent intent = new Intent(this, MainActivityAsteroidBelt.class);
        startActivity(intent);
    }
    public void openQuizC(View view){
        Intent intent = new Intent(this, MainActivityQuizC.class);
        startActivity(intent);
    }
}