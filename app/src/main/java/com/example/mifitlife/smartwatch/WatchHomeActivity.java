package com.example.mifitlife.smartwatch;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

/**
 * SMARTWATCH - Pantalla 1: INICIO.
 * Muestra hora (arriba izq.), frecuencia cardiaca (arriba der.), calorías (al lado de FC),
 * pasos (centro, protagonista) y progreso del objetivo diario (parte inferior).
 * Datos simulados. Deslizar para navegar.
 */
public class WatchHomeActivity extends AppCompatActivity {

    private GestureDetector gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_home);
        gesture = WatchNav.build(this);

        // Datos simulados
        int pasos = 6248, objetivo = 8000;
        ((TextView) findViewById(R.id.txtTime)).setText("10:45");
        ((TextView) findViewById(R.id.txtHeart)).setText("78 BPM");
        ((TextView) findViewById(R.id.txtCalories)).setText("420 kcal");
        ((TextView) findViewById(R.id.txtSteps)).setText(String.valueOf(pasos));

        int pct = pasos * 100 / objetivo;
        ProgressBar bar = findViewById(R.id.progressGoal);
        bar.setMax(objetivo);
        bar.setProgress(pasos);
        ((TextView) findViewById(R.id.txtGoalProgress)).setText(pasos + " / " + objetivo + " · " + pct + "%");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gesture.onTouchEvent(event) || super.onTouchEvent(event);
    }
}
