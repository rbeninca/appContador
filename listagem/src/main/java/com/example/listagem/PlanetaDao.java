package com.example.listagem;

import java.util.ArrayList;

public class PlanetaDao {
    ArrayList<Planeta> planetas;

    public PlanetaDao() {
            planetas=new ArrayList<>();
            planetas.add(new Planeta("mercurio",R.drawable.mercury));
            planetas.add(new Planeta("venus",R.drawable.venus));
            planetas.add(new Planeta("Terra",R.drawable.earth));
            planetas.add(new Planeta("Marte",R.drawable.mars));
            planetas.add(new Planeta("Jupter",R.drawable.jupter));
            planetas.add(new Planeta( "Saturno", R.drawable.saturn));
            planetas.add(new Planeta("Urano",R.drawable.uranus));
            planetas.add((new Planeta("Pluto",R.drawable.sun)));



    }
    public ArrayList<Planeta> getAllPlanetas(){
        return  this.planetas;
    }
}
