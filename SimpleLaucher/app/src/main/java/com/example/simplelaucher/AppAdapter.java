package com.example.simplelaucher;



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {
    private List<AppInfo> appList;
    private Context mContext;
    /*Construtor do nosso adapter, que recebe o contexto e a lista de aplicativos, observe que nesse caso nao estamos passando
    * o layout do item, pois ele esta sendo inflado no metodo onCreateViewHolder, de forma fixa, mas poderiamos passar o layout
    * */
    public AppAdapter(Context context,List<AppInfo> appList) {
        this.mContext = context;
        this.appList = appList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppInfo app = appList.get(position);
        holder.appName.setText(app.getName());
        holder.appPackage.setText(app.getPackageName());
        holder.appIcon.setImageDrawable(app.getIcon());

        // Alterar o fundo com base em se é um app de sistema ou launchable
        if (app.isSystemApp()) {
            holder.itemLayout.setBackgroundColor(0xFFFFE0E0); // Vermelho claro para apps de sistema
        } else if (app.isLaunchable()) {
            holder.itemLayout.setBackgroundColor(0xFFE0FFE0); // Verde claro para apps launchable
        } else {
            holder.itemLayout.setBackgroundColor(0xFFFFFFFF); // Branco para os demais
        }

        // Configurar o OnClickListener para abrir o aplicativo
        holder.itemLayout.setOnClickListener(v -> {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(app.getPackageName());

            // Verificar se o Intent não é nulo
            if (launchIntent != null) {
                // Adicionar flags para iniciar uma nova tarefa
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    mContext.startActivity(launchIntent);
                } catch (Exception e) {
                    Toast.makeText(mContext, "Erro ao iniciar o aplicativo", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(mContext, "Aplicativo não pode ser iniciado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView appIcon;
        TextView appName, appPackage;
        LinearLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            appIcon = itemView.findViewById(R.id.appIcon);
            appName = itemView.findViewById(R.id.appName);
            appPackage = itemView.findViewById(R.id.appPackage);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }
}