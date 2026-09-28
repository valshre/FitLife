package com.example.mifitlife.tv;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mifitlife.R;
import com.example.fitlife.widgets.LineChartView;
import com.example.fitlife.widgets.PieChartView;


public class TvStatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_statistics);
        TvNav.wire(this);

        String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};

        // 1) Pasos por día (gráfica lineal)
        LineChartView pasos = findViewById(R.id.chartSteps);
        pasos.setData(
                new float[]{3200, 4100, 5300, 6000, 6248, 7200, 8100},
                dias, Color.parseColor("#F6777E"));

        // 2) Calorías por día (gráfica de pastel)
        PieChartView cal = findViewById(R.id.chartCalories);
        cal.setData(
                new float[]{320, 410, 380, 420, 500, 610, 700},
                new int[]{
                        Color.parseColor("#F6777E"),
                        Color.parseColor("#E94B55"),
                        Color.parseColor("#D95760"),
                        Color.parseColor("#4A90E2"),
                        Color.parseColor("#54BFA3"),
                        Color.parseColor("#707070"),
                        Color.parseColor("#111111")
                },
                dias);

        // 3) Tiempo de ejercicio (gráfica lineal)
        LineChartView tiempo = findViewById(R.id.chartTime);
        tiempo.setData(
                new float[]{20, 25, 30, 28, 35, 40, 55},
                dias, Color.parseColor("#4A90E2"));
    }
}
