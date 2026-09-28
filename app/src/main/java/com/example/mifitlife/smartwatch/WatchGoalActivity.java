package com.example.mifitlife.smartwatch;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;
import com.example.fitlife.widgets.CircleProgressView;

import com.example.mifitlife.smartwatch.WatchNav;

/**
 * SMARTWATCH - Pantalla 4: OBJETIVO DIARIO.
 * Comparativa meta vs pasos actuales en el centro (los pasos ocupan la mayor parte),
 * y el porcentaje completado en la parte inferior. Usa un anillo de progreso.
 */
public class WatchGoalActivity extends AppCompatActivity {

    private GestureDetector gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_goal);
        gesture = WatchNav.build(this);

        int pasos = 6248, meta = 8000;
        int pct = pasos * 100 / meta;

        ((TextView) findViewById(R.id.txtCurrentSteps)).setText(String.valueOf(pasos));
        ((TextView) findViewById(R.id.txtGoalSteps)).setText("/ " + meta);
        ((TextView) findViewById(R.id.txtPercent)).setText(pct + "%");

        CircleProgressView ring = findViewById(R.id.ringGoal);
        ring.setProgress(pasos / (float) meta);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gesture.onTouchEvent(event) || super.onTouchEvent(event);
    }
}
