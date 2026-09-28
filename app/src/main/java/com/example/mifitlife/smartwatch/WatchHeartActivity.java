package com.example.mifitlife.smartwatch;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

/**
 * SMARTWATCH - Pantalla 2: FRECUENCIA CARDIACA.
 * Frecuencia actual en el centro (elemento principal), máxima en pequeño a un lado
 * separada por "/", mínima y máxima apiladas en la esquina superior derecha,
 * y un indicador visual (barra) que ubica la frecuencia actual entre mín y máx.
 */
public class WatchHeartActivity extends AppCompatActivity {

    private GestureDetector gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_heart);
        gesture = WatchNav.build(this);

        int actual = 78, min = 65, max = 145;
        ((TextView) findViewById(R.id.txtCurrent)).setText(String.valueOf(actual));
        ((TextView) findViewById(R.id.txtMaxInline)).setText("/ " + max + " BPM");
        ((TextView) findViewById(R.id.txtMinValue)).setText(String.valueOf(min));
        ((TextView) findViewById(R.id.txtMaxValue)).setText(String.valueOf(max));

        ProgressBar bar = findViewById(R.id.progressHeart);
        bar.setMax(max - min);
        bar.setProgress(actual - min);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gesture.onTouchEvent(event) || super.onTouchEvent(event);
    }
}
