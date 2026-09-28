package com.example.fitlife.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Gráfica lineal (tipo exponencial/lineal) dibujada manualmente en Java.
 * Se usa para "Pasos por día" y "Tiempo de ejercicio" en la pantalla de Estadísticas (Smart TV).
 * Los datos y el color de línea se asignan desde la Activity con setData().
 */
public class LineChartView extends View {

    private float[] values = {0f};
    private String[] labels = {""};
    private int lineColor = Color.parseColor("#4A90E2");

    private final Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LineChartView(Context context) { super(context); init(); }
    public LineChartView(Context context, AttributeSet attrs) { super(context, attrs); init(); }
    public LineChartView(Context context, AttributeSet attrs, int def) { super(context, attrs, def); init(); }

    private void init() {
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(6f);
        fillPaint.setStyle(Paint.Style.FILL);
        pointPaint.setStyle(Paint.Style.FILL);
        axisPaint.setColor(Color.parseColor("#DDDDDD"));
        axisPaint.setStrokeWidth(2f);
        textPaint.setColor(Color.parseColor("#707070"));
        textPaint.setTextSize(26f);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setData(float[] values, String[] labels, int lineColor) {
        this.values = values;
        this.labels = labels;
        this.lineColor = lineColor;
        linePaint.setColor(lineColor);
        pointPaint.setColor(lineColor);
        fillPaint.setColor((lineColor & 0x00FFFFFF) | 0x33000000);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (values == null || values.length == 0) return;

        float padL = 60f, padR = 30f, padT = 30f, padB = 60f;
        float w = getWidth() - padL - padR;
        float h = getHeight() - padT - padB;

        float max = 1f;
        for (float v : values) if (v > max) max = v;

        // Ejes
        canvas.drawLine(padL, padT, padL, padT + h, axisPaint);
        canvas.drawLine(padL, padT + h, padL + w, padT + h, axisPaint);

        int n = values.length;
        float stepX = n > 1 ? w / (n - 1) : w;

        Path line = new Path();
        Path fill = new Path();
        float[] xs = new float[n];
        float[] ys = new float[n];
        for (int i = 0; i < n; i++) {
            float x = padL + stepX * i;
            float y = padT + h - (values[i] / max) * h;
            xs[i] = x; ys[i] = y;
            if (i == 0) { line.moveTo(x, y); fill.moveTo(x, padT + h); fill.lineTo(x, y); }
            else { line.lineTo(x, y); fill.lineTo(x, y); }
        }
        fill.lineTo(xs[n - 1], padT + h);
        fill.close();

        canvas.drawPath(fill, fillPaint);
        canvas.drawPath(line, linePaint);

        for (int i = 0; i < n; i++) {
            canvas.drawCircle(xs[i], ys[i], 8f, pointPaint);
            if (labels != null && i < labels.length) {
                canvas.drawText(labels[i], xs[i], padT + h + 42f, textPaint);
            }
            canvas.drawText(String.valueOf((int) values[i]), xs[i], ys[i] - 16f, textPaint);
        }
    }
}
