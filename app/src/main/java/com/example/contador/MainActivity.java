package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button btnA,btnB;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            btnA=findViewById(R.id.bntclickA);
            btnB=findViewById(R.id.bntclickB);
            btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(intent);
                }
            });

            btnB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getApplicationContext(),MainActivity3.class);
                    EditText editText;
                    editText=findViewById(R.id.edText);
                    String s=editText.getText().toString();
                    intent.putExtra("msg",s);
                    startActivity(intent);
                }
            });


        Log.d("Ciclo de vida", "passou pelo onCreate");
    }


}