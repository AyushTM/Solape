package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivityTerrestrial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_terrestrial);
    }

    public void openMercury(View view) {
        Intent intent = new Intent(this, MainActivityMercury.class);
        startActivity(intent);
    }
    public void openVenus(View view) {
        Intent intent = new Intent(this, MainActivityVenus.class);
        startActivity(intent);
    }
    public void openEarth(View view) {
        Intent intent = new Intent(this, MainActivityEarth.class);
        startActivity(intent);
    }
    public void openMars(View view) {
        Intent intent = new Intent(this, MainActivityMars.class);
        startActivity(intent);
    }
    public void openQuizT(View view) {
        Intent intent = new Intent(this, MainActivityQuizT.class);
        startActivity(intent);
    }
}