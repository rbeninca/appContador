package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimplePaint extends View {
    Path mPath;
    Paint mPaint;
    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint= new Paint();
        mPath =new Path();

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(6f);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x,y);
                invalidate();
                return (true);
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x,y);
                invalidate();
                return (true);
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onTouchEvent(event);
    }
}
