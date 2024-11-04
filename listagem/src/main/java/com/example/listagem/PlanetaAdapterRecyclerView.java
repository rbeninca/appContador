package com.example.listagem;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetaAdapterRecyclerView extends RecyclerView.Adapter<PlanetaAdapterRecyclerView.PlanetaVH> {
    Context mContext;
    int mResource;
    List<Planeta> mListPlaneta;
    public PlanetaAdapterRecyclerView(Context context, int resource, List<Planeta> objs){
        mContext=context;
        mResource=resource;
        mListPlaneta=objs;
    }

    @Override
    public PlanetaVH onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v =View.inflate(mContext,mResource,null);
        return new PlanetaVH(v);
    }
    @Override
    public void onBindViewHolder(@NonNull PlanetaVH planetaVH, int i) {
            Planeta p= (Planeta) mListPlaneta.get(i);
            planetaVH.imageView.setImageResource(p.foto);
            planetaVH.tvNome.setText(p.nome); ;
    }
    @Override
    public int getItemCount() {
        return mListPlaneta.size();
    }
    public class PlanetaVH extends RecyclerView.ViewHolder {
        TextView tvNome;
        ImageView imageView;
        public PlanetaVH(@NonNull View itemView) {
            super(itemView);
            tvNome=itemView.findViewById(R.id.textViewNome);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
