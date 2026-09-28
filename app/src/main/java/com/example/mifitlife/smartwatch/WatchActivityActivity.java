package com.example.mifitlife.smartwatch;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

public class WatchActivityActivity extends AppCompatActivity {

    private GestureDetector gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_activity);

        // Inicializar el detector de gestos para deslizamiento
        gesture = WatchNav.build(this);

        // Vinculación de los botones de actividad
        bind(R.id.btnWalk, "Caminar");
        bind(R.id.btnRun, "Correr");
        bind(R.id.btnBike, "Bicicleta");
        bind(R.id.btnTrain, "Entrenamiento");
    }

    private void bind(int id, final String nombre) {
        Button b = findViewById(id);
        if (b != null) {
            b.setContentDescription(nombre);
            b.setOnClickListener(v ->
                    Toast.makeText(WatchActivityActivity.this, nombre + " iniciada", Toast.LENGTH_SHORT).show()
            );
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gesture != null && gesture.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }
}