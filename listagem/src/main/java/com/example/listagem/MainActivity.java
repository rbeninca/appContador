package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlanetaDao planetaDao =new PlanetaDao();
        PlanetaAdapterRecyclerView padapterRV= new PlanetaAdapterRecyclerView(this,
                R.layout.planeta_item,
                planetaDao.getAllPlanetas()
                );

        recyclerView.setAdapter(padapterRV);

    }
}