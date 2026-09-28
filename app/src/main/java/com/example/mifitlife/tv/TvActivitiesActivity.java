package com.example.mifitlife.tv;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

/**
 * SMART TV - Pantalla 3: ACTIVIDADES.
 * Las mismas cuatro actividades del Smartwatch pero con NOMBRE. Al seleccionar
 * una (con el control remoto / foco) se muestra una breve descripción de cómo
 * usarla. Las tarjetas son focusable con señal visual clara.
 */
public class TvActivitiesActivity extends AppCompatActivity {

    private TextView title;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_activities);
        TvNav.wire(this);

        title = findViewById(R.id.txtSelectedTitle);
        desc = findViewById(R.id.txtSelectedDesc);

        bind(R.id.cardWalk, "\ud83d\udeb6  Caminar",
                "Selecciona Caminar y comienza a moverte a paso ligero. Ideal para calentar; la app cuenta tus pasos y calorías automáticamente.");
        bind(R.id.cardRun, "\ud83c\udfc3  Correr",
                "Selecciona Correr para registrar tu sesión de carrera. Mantén un ritmo constante; se medirá distancia, tiempo y frecuencia cardiaca.");
        bind(R.id.cardBike, "\ud83d\udeb4  Bicicleta",
                "Selecciona Bicicleta antes de salir a rodar. Se registra la duración y las calorías del recorrido en tiempo real.");
        bind(R.id.cardTrain, "\ud83d\udcaa  Entrenamiento",
                "Selecciona Entrenamiento para tus rutinas de fuerza. Sigue las series y descansos mientras la app controla el tiempo total.");
    }

    private void bind(int id, final String nombre, final String descripcion) {
        View card = findViewById(id);
        View.OnFocusChangeListener focus = new View.OnFocusChangeListener() {
            @Override public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) show(nombre, descripcion);
            }
        };
        card.setOnFocusChangeListener(focus);
        card.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { show(nombre, descripcion); }
        });
    }

    private void show(String nombre, String descripcion) {
        title.setText(nombre);
        desc.setText(descripcion);
    }
}
