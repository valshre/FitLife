package com.example.mifitlife.tv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

/**
 * SMART TV - Pantalla 1: DASHBOARD.
 * Resumen diario en una columna del 30% (calorías, frecuencia y objetivo)
 */
public class TvDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_dashboard);
        TvNav.wire(this);
    }
}
