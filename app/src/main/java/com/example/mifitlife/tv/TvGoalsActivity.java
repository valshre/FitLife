package com.example.mifitlife.tv;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;
import com.example.fitlife.widgets.CircleProgressView;

/**
 * SMART TV - Pantalla 5: OBJETIVOS.
 * Objetivo diario en grande, progreso a un lado, objetivo semanal debajo con
 * una frase motivacional y una lista de 5 objetivos alcanzados. Datos simulados.
 */
public class TvGoalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_goals);
        TvNav.wire(this);

        int pasos = 6248, meta = 8000;
        CircleProgressView ring = findViewById(R.id.ringGoals);
        ring.setProgress(pasos / (float) meta);
        ((TextView) findViewById(R.id.txtGoalsPercent)).setText(pasos * 100 / meta + "%");
    }
}
