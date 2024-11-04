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

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    int mResource;
    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta>objects ) {
        super(context, resource, objects);
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(getContext());
        View view=layoutInflater.inflate(mResource,parent,false);

        ImageView iv=view.findViewById(R.id.imageView);
        TextView tv=view.findViewById(R.id.textViewNome);

        Planeta p=getItem(position);

        iv.setImageResource(p.foto);
        tv.setText(p.nome);


        return view;
    }
}
