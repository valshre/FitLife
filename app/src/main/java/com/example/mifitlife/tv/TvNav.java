package com.example.mifitlife.tv;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.mifitlife.R;

/**
 * Conecta los botones de la barra de navegación (tv_navbar.xml) del Smart TV
 * con sus respectivas secciones. La navegación es por control remoto / foco.
 */
public final class TvNav {

    private TvNav() {}

    public static void wire(final Activity a) {
        link(a, R.id.btnNavDashboard, TvDashboardActivity.class);
        link(a, R.id.btnNavStats, TvStatisticsActivity.class);
        link(a, R.id.btnNavActivities, TvActivitiesActivity.class);
        link(a, R.id.btnNavHistory, TvHistoryActivity.class);
        link(a, R.id.btnNavGoals, TvGoalsActivity.class);
    }

    private static void link(final Activity a, int id, final Class<?> target) {
        View v = a.findViewById(id);
        if (v == null) return;
        if (a.getClass().equals(target)) {
            v.setSelected(true); // resalta la sección actual
            return;
        }
        v.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                a.startActivity(new Intent(a, target));
                a.overridePendingTransition(0, 0);
            }
        });
    }
}
