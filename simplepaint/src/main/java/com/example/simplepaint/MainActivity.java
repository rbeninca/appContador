package com.example.simplepaint;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.io.DataInput;

public class MainActivity extends AppCompatActivity {
    ImageButton ibColor, ibClear, ibFingerShape, ibSquareShape, ibCircleShape, ibLayersUndo, ibLayers, ibShareFile;
    SimplePaint simplePaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplePaint= findViewById(R.id.paintView);
        ibColor = findViewById(R.id.ibColor);
        ibFingerShape = findViewById(R.id.ibFingerShape);
        ibSquareShape = findViewById(R.id.ibSquareShape);
        ibCircleShape = findViewById(R.id.ibCircleShape);
        ibLayersUndo = findViewById(R.id.ibLayersUndo);
        ibLayers = findViewById(R.id.ibLayers);
        ibShareFile = findViewById(R.id.ibShareFile);


        ibColor.setOnClickListener(v -> {
            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Selecionar",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setColor(envelope);
                                }
                            })
                    .setNegativeButton("Canelar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        });
        ibLayersUndo.setOnClickListener(v -> {
            simplePaint.undo();
        });
        ibCircleShape.setOnClickListener(v -> {
            simplePaint.shape = SimplePaint.Shape.CIRCLE;
        });
        ibSquareShape.setOnClickListener(v -> {
            simplePaint.shape = SimplePaint.Shape.SQUARE;
        });
        ibFingerShape.setOnClickListener(v -> {
            simplePaint.shape = SimplePaint.Shape.FINGER;
        });

        ibShareFile.setOnClickListener(v -> {

        });
    }
    public  void setColor (ColorEnvelope envelope){
        int color = envelope.getColor();
        simplePaint.setColor(color);
        ibColor.setBackgroundColor(color);

    }
}