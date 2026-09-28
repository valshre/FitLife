package com.example.mifitlife.smartwatch;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;

/**
 * SMARTWATCH - Pantalla 5: NOTIFICACIONES.
 */
public class WatchNotificationsActivity extends AppCompatActivity {

    private GestureDetector gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_notifications);
        gesture = WatchNav.build(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // El deslizamiento horizontal navega; el vertical desplaza el ScrollView.
        gesture.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
