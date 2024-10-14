package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] nomes = new String[] {"Picareta", "Jhones Dark", "Camili","Daniela","Thoninho"};
    ListView listView; //null
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,
                                            android.R.layout.simple_list_item_1,
                                            android.R.id.text1,
                                            nomes
                );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,Integer.toString(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}