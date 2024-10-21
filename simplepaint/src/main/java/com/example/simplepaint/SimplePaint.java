package com.example.simplepaint;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class SimplePaint extends View {

    public enum Shape {
        CIRCLE, SQUARE, FINGER
    }
    Shape shape = Shape.FINGER;
    public class CoordenadasTraco{
        float InicialX;
        float InicialY;
    }
    ArrayList<Layer> camadas;
    Layer previewLayer;
    CoordenadasTraco coordenadasTraco;
    //Define enum para formas shapes (círculo, quadrado, etc)
    public SimplePaint(Context context, AttributeSet attrs) {
        super(context, attrs);
        camadas = new ArrayList<Layer>();
        camadas.add(new Layer());
        previewLayer = new Layer();
        setupLayer(previewLayer);
        previewLayer.paint.setColor(Color.RED);
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
        canvas.drawPath(previewLayer.path,previewLayer.paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                addLayer();
                getCurrenteLayer().path.moveTo(x, y);
                coordenadasTraco = new CoordenadasTraco();
                coordenadasTraco.InicialX = x;
                coordenadasTraco.InicialY = y;
                return true;
            case MotionEvent.ACTION_MOVE:
                if (shape == Shape.CIRCLE) {
                    //adicionada a forma de círculo com tamanho apartir da coordenada inicia com raio  distancia linear entre inicial e atual
                    getCurrenteLayer().path.reset();
                    getCurrenteLayer().path.moveTo(coordenadasTraco.InicialX, coordenadasTraco.InicialY);
                    previewLayer.clear();
                    previewLayer.path.moveTo(coordenadasTraco.InicialX, coordenadasTraco.InicialY);
                    previewLayer.path.lineTo(x,y);

                    float raio = (float) Math.sqrt(Math.pow(coordenadasTraco.InicialX - x, 2) +
                            Math.pow(coordenadasTraco.InicialY - y, 2));
                    //adiciona um texto com tamanho do raio do círculo na tela de desenho e adiciona o círculo
                    getCurrenteLayer().path.addCircle(x, y, raio, Path.Direction.CW);
                } else if (shape == Shape.SQUARE) {
                    //adicionada a forma de quadrado com tamanho apartir da coordenada inicia
                    getCurrenteLayer().path.addRect(coordenadasTraco.InicialX, coordenadasTraco.InicialY, x, y, Path.Direction.CW);
                } else if (shape == Shape.FINGER) {
                    getCurrenteLayer().path.addRect(x - 30, y - 30, x + 30, y + 30, Path.Direction.CW);
                } else {
                    getCurrenteLayer().path.lineTo(x, y);
                }
                break;
            case MotionEvent.ACTION_UP:
                previewLayer.path.reset();
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
    //cria nova camada para desenhar mantendo configurações
    public void addLayer() {
        camadas.add(new Layer(getCurrenteLayer().paint));
        invalidate();
    }
    //Define shape atual do tipo enum Shape
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    //Desfaz a última ação
    public void undo() {
        if (camadas.size() > 1) {
            camadas.remove(camadas.size() - 1);
            invalidate();
        }else {
            clear();
        }
    }



}
