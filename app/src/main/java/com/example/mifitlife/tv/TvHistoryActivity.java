package com.example.mifitlife.tv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

/**
 * SMART TV - Pantalla 4: HISTORIAL.
 * Lista sencilla navegable con el control remoto (flechas arriba/abajo). Cada
 * registro es focusable y muestra claramente el foco. Datos simulados.
 */
public class TvHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_history);
        TvNav.wire(this);
    }
}
