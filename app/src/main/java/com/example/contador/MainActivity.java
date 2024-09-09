package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button button;
    TextView tv;
    int cont;//var button vazia (null)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =findViewById(R.id.bntclick);
        tv =findViewById(R.id.textView);
        button.setText("click");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont++;
                Button b=(Button) view;
                b.setText(String.valueOf(cont));
                tv.setText(String.valueOf(cont));

            }
        });
    }
}