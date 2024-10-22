package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<String> nomes;
    EditText editTextNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        editTextNome=findViewById(R.id.editTextText);
        Button button= findViewById(R.id.button);


        carregaLista();
    }

    public  void carregaLista(){
        PlanetasDao planetasDao = new PlanetasDao();

        PlanetasAdapter adapter = new PlanetasAdapter( this, R.layout.item_lista, planetasDao.getPlanetas());

        listView.setAdapter(adapter);
    }
}