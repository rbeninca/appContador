package com.example.simplepaint;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SimplePaint extends View {
    Paint paint ;
    Path path ;

    public SimplePaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.paint = new Paint();
        this.path = new Path();
        setup();

    }
    public void setup(){
        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(0xff000000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }


    public void clear() {
        path.reset(); // Reseta o caminho
        invalidate(); // Re-renderiza a View
    }
    public void draw(){
        invalidate();
    }
    public void setPaint(Paint paint){
        this.paint = paint;
    }
    public void setPath(Path path){
        this.path = path;
    }
    public Paint getPaint(){
        return paint;
    }
    public Path getPath(){
        return path;
    }
    public void setPaintColor(int color){
        paint.setColor(color);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return super.onTouchEvent(event);
    }
}
