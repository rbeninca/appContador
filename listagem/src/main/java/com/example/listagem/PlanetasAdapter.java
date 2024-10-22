package com.example.listagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetasAdapter extends ArrayAdapter<Planeta> {
    public PlanetasAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(getContext());
        View v=layoutInflater.inflate(R.layout.item_lista,parent,false);

        TextView textView=v.findViewById(R.id.textView);
        ImageView imageView=v.findViewById(R.id.imageView2);

        Planeta p=getItem(position);

        textView.setText(p.nome);
        imageView.setImageResource(p.imgPlaneta);
        
        return v;
    }
}
