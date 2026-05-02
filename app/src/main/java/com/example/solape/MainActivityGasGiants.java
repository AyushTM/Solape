package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityGasGiants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gas_giants);
    }
    public void openJupiter(View view) {
        Intent intent = new Intent(this, MainActivityJupiter.class);
        startActivity(intent);
    }

    public void openSaturn(View view) {
        Intent intent = new Intent(this, MainActivitySaturn.class);
        startActivity(intent);
    }
    public void openQuizG(View view) {
        Intent intent = new Intent(this, MainActivityQuizG.class);
        startActivity(intent);
    }
}