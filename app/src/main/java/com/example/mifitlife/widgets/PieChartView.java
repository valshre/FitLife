package com.example.fitlife.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Gráfica de pastel dibujada manualmente en Java.
 * Se usa para "Calorías por día" en la pantalla de Estadísticas (Smart TV).
 */
public class PieChartView extends View {

    private float[] values = {1f};
    private int[] colors = {Color.parseColor("#F6777E")};
    private String[] labels = {""};

    private final Paint slicePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF oval = new RectF();

    public PieChartView(Context context) { super(context); init(); }
    public PieChartView(Context context, AttributeSet attrs) { super(context, attrs); init(); }
    public PieChartView(Context context, AttributeSet attrs, int def) { super(context, attrs, def); init(); }

    private void init() {
        slicePaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(28f);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setData(float[] values, int[] colors, String[] labels) {
        this.values = values;
        this.colors = colors;
        this.labels = labels;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (values == null || values.length == 0) return;

        float total = 0f;
        for (float v : values) total += v;
        if (total <= 0) return;

        float size = Math.min(getWidth(), getHeight()) - 40f;
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;
        oval.set(cx - size / 2f, cy - size / 2f, cx + size / 2f, cy + size / 2f);

        float start = -90f;
        for (int i = 0; i < values.length; i++) {
            float sweep = (values[i] / total) * 360f;
            slicePaint.setColor(colors[i % colors.length]);
            canvas.drawArc(oval, start, sweep, true, slicePaint);

            double mid = Math.toRadians(start + sweep / 2f);
            float lx = (float) (cx + Math.cos(mid) * size / 4f);
            float ly = (float) (cy + Math.sin(mid) * size / 4f);
            int pct = Math.round((values[i] / total) * 100f);
            canvas.drawText(pct + "%", lx, ly, textPaint);
            start += sweep;
        }
    }
}
