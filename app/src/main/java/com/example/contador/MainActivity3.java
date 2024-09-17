package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity3  extends Activity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        textView=findViewById(R.id.textView2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.setText(getIntent().getExtras().getString("msg"));

    }
}
