package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityIceGiants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ice_giants);
    }
    public void openUranus(View view) {
        Intent intent = new Intent(this, MainActivityUranus.class);
        startActivity(intent);
    }
    public void openNeptune(View view) {
        Intent intent = new Intent(this, MainActivityNeptune.class);
        startActivity(intent);
    }
    public void openQuizI(View view) {
        Intent intent = new Intent(this, MainActivityQuizI.class);
        startActivity(intent);
    }
}