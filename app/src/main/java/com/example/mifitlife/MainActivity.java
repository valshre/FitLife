package com.example.mifitlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.smartwatch.WatchHomeActivity;
import com.example.mifitlife.tv.TvDashboardActivity;

/**
 * Pantalla inicial de selección de versión.
 * Solo sirve para elegir entre la versión Smartwatch y la versión Smart TV.
 * NO sustituye ninguna de las cinco pantallas de cada versión.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWatch = findViewById(R.id.btnWatch);
        Button btnTv = findViewById(R.id.btnTv);

        btnWatch.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WatchHomeActivity.class));
            }
        });

        btnTv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TvDashboardActivity.class));
            }
        });
    }
}
