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
        nomes=new ArrayList();
        for (String s: new String[] {"Kaua","Lucas","Gustavo","Augusto", "Eduarda","Gelasio"}) {
            nomes.add(s);
        }
        button.setOnClickListener(v->{
            String nome=editTextNome.getText().toString();
            nomes.add(nome);
            carregaLista();
        });
        carregaLista();
    }

    public  void carregaLista(){
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );

        listView.setAdapter(adapter);
    }
}