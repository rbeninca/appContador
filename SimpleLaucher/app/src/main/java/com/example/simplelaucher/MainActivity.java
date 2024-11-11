package com.example.simplelaucher;


import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppAdapter adapter;
    private List<AppInfo> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        appList = getInstalledApps();
        adapter = new AppAdapter(this,appList);
        recyclerView.setAdapter(adapter);
    }


    private List<AppInfo> getInstalledApps() {
        /*Metodo apenas para recupear a listagem de App do systema
        * Podemos melhorar esse metodo para que ele retorne apenas os aplicativos que podem ser iniciados
        * ou seja, que tem um Intent de inicialização abaixo segue um exemplo de como fazer isso
        * */

        // Lista de aplicativos  todos apps instalados
        List<ApplicationInfo> allapps = new ArrayList<>();
        PackageManager pm = getPackageManager();
        allapps= pm.getInstalledApplications(PackageManager.GET_META_DATA);  //Obsere aqui que estamos pegando todos os aplicativos instalados no sistema


        // Intent para buscar aplicativos que podem ser iniciados
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        // Obter apenas os aplicativos que têm um Intent de inicialização
        List<ResolveInfo> launchableApps = pm.queryIntentActivities(mainIntent, PackageManager.MATCH_ALL); //Observe que estamos pegando todos os aplicativos que podem ser iniciados


        /*Aqui vamos criar uma lista de AppInfo, que é a classe que criamos para representar um aplicativo e suas informações*/
        List<AppInfo> apps = new ArrayList<>();
        for (ResolveInfo resolveInfo : launchableApps) {
            String packageName = resolveInfo.activityInfo.packageName;
            String name = (String) resolveInfo.loadLabel(pm);
            Drawable icon = resolveInfo.loadIcon(pm);

            boolean isSystemApp = false;
            try {
                // Verificar se é um aplicativo do sistema
                isSystemApp = (pm.getApplicationInfo(packageName, 0).flags & ApplicationInfo.FLAG_SYSTEM) != 0;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            // Adicionar à lista de aplicativos
            apps.add(new AppInfo(name, packageName, icon, isSystemApp, true));
        }
        return apps;
    }
}