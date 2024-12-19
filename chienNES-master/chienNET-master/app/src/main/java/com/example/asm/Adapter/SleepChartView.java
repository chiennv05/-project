package com.example.asm.Adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SleepChartView extends View {
    private Paint paint;
    private float[] dataPoints = new float[] {1, 5, 3, 2, 6}; // Dữ liệu mẫu

    public SleepChartView(Context context) {
        super(context);
        init();
    }

    public SleepChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SleepChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dataPoints == null || dataPoints.length == 0) return;

        float width = getWidth();
        float height = getHeight();
        float stepX = width / (dataPoints.length - 1);
        float scaleY = height / 10;

        for (int i = 0; i < dataPoints.length - 1; i++) {
            float startX = i * stepX;
            float startY = height - (dataPoints[i] * scaleY);
            float stopX = (i + 1) * stepX;
            float stopY = height - (dataPoints[i + 1] * scaleY);

            canvas.drawLine(startX, startY, stopX, stopY, paint);
        }
    }

    public void setDataPoints(float[] dataPoints) {
        this.dataPoints = dataPoints;
        invalidate(); // Yêu cầu vẽ lại view
    }
}
