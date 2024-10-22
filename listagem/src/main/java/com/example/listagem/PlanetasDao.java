package com.example.listagem;

import java.util.ArrayList;

public class PlanetasDao {
    ArrayList<Planeta> planetas;

    public PlanetasDao(){
        planetas =new ArrayList<>();
        planetas.add(new Planeta("Mercurio",R.drawable.mercury));
        planetas.add(new Planeta("Venus",R.drawable.venus));
        planetas.add(new Planeta("Terra",R.drawable.earth));
        planetas.add(new Planeta("Marte",R.drawable.mars));
    }

    public  ArrayList<Planeta> getPlanetas(){
        return  this.planetas;

    }
}
