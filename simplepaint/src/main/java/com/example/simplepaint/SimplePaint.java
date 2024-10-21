package com.example.simplepaint;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SimplePaint extends View {
    ArrayList<Layer> camadas;
    public SimplePaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        camadas = new ArrayList<Layer>();
        camadas.add(new Layer());
        setupLayer(getCurrenteLayer());
    }
    public void setupLayer(Layer layer){
        layer.paint.setAntiAlias(true);
        layer.paint.setStrokeWidth(6f);
        layer.paint.setColor(0xff000000);
        layer.paint.setStyle(Paint.Style.STROKE);
        layer.paint.setStrokeJoin(Paint.Join.ROUND);
    }
    public void clear() {
        getCurrenteLayer().path.reset();
        invalidate(); // Re-renderiza a View
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        for (Layer layer : camadas){
            canvas.drawPath(layer.path, layer.paint);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                getCurrenteLayer().path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                getCurrenteLayer().path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    public Layer getCurrenteLayer(){
        return camadas.get(camadas.size()-1);
    }

    public void setColor(int color) {
        camadas.add(new Layer(getCurrenteLayer().paint));
        getCurrenteLayer().paint.setColor(color);
    }
}
