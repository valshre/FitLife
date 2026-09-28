package com.example.mifitlife.smartwatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Utilidad de navegación para el Smartwatch mediante DESLIZAMIENTOS.
 * Deslizar a la izquierda -> siguiente pantalla.
 * Deslizar a la derecha  -> pantalla anterior.
 * Orden: Inicio -> Frecuencia -> Actividad -> Objetivo -> Notificaciones.
 */
public final class WatchNav {

    public static final Class<?>[] ORDER = {
            WatchHomeActivity.class,
            WatchHeartActivity.class,
            WatchActivityActivity.class,
            WatchGoalActivity.class,
            WatchNotificationsActivity.class
    };

    private WatchNav() {}

    private static int indexOf(Activity a) {
        for (int i = 0; i < ORDER.length; i++) {
            if (ORDER[i].equals(a.getClass())) return i;
        }
        return 0;
    }

    @SuppressWarnings("deprecation")
    private static void go(Activity a, int target) {
        if (target < 0 || target >= ORDER.length) return;
        a.startActivity(new Intent(a, ORDER[target]));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            a.overrideActivityTransition(Activity.OVERRIDE_TRANSITION_CLOSE, 0, 0);
        } else {
            a.overridePendingTransition(0, 0);
        }

        a.finish();
    }

    /** Devuelve un GestureDetector que cambia de pantalla al deslizar horizontalmente. */
    public static GestureDetector build(final Activity a) {
        return new GestureDetector(a, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float vx, float vy) {
                if (e1 == null || e2 == null) return false;
                float dx = e2.getX() - e1.getX();
                if (Math.abs(dx) > 100 && Math.abs(vx) > 100) {
                    int idx = indexOf(a);
                    if (dx < 0) go(a, idx + 1);   // izquierda -> siguiente
                    else go(a, idx - 1);          // derecha -> anterior
                    return true;
                }
                return false;
            }
        }, new Handler(Looper.getMainLooper()));
    }
}