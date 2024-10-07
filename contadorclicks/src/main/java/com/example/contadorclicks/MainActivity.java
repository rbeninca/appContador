package com.example.contadorclicks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        // Set the initial value of the counter
        textView.setText("0");

        // Set the click listener for the button
        button.setOnClickListener(v -> {
            // Increment the counter
            count++;
            textView.setText(String.valueOf(count));
        });
    }
}