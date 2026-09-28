package com.example.fitlife.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Anillo de progreso circular dibujado en Java.
 * Se usa como indicador visual de progreso (Smartwatch: Inicio y Objetivo diario).
 */
public class CircleProgressView extends View {

    private float progress = 0f; // 0..1
    private int ringColor = Color.parseColor("#F6777E");

    private final Paint bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint fgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF oval = new RectF();

    public CircleProgressView(Context context) { super(context); init(); }
    public CircleProgressView(Context context, AttributeSet attrs) { super(context, attrs); init(); }
    public CircleProgressView(Context context, AttributeSet attrs, int def) { super(context, attrs, def); init(); }

    private void init() {
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setStrokeWidth(18f);
        bgPaint.setColor(Color.parseColor("#FFF0F1"));
        fgPaint.setStyle(Paint.Style.STROKE);
        fgPaint.setStrokeWidth(18f);
        fgPaint.setStrokeCap(Paint.Cap.ROUND);
        fgPaint.setColor(ringColor);
    }

    public void setProgress(float p) {
        this.progress = Math.max(0f, Math.min(1f, p));
        invalidate();
    }

    public void setRingColor(int color) {
        this.ringColor = color;
        fgPaint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float pad = 24f;
        float size = Math.min(getWidth(), getHeight()) - pad * 2;
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;
        oval.set(cx - size / 2f, cy - size / 2f, cx + size / 2f, cy + size / 2f);
        canvas.drawArc(oval, 0, 360, false, bgPaint);
        canvas.drawArc(oval, -90, 360 * progress, false, fgPaint);
    }
}
