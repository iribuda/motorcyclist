package com.company.dressing;

import com.company.clothes.Ammunition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Wardrobe {
    private ArrayList<Ammunition> ammunitions;

    public Wardrobe(){
        ammunitions = new ArrayList<>();
    }

    public void addToWardrobe(ArrayList<Ammunition> ammunitions){
        this.ammunitions.addAll(ammunitions);
    }

    public ArrayList<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public Ammunition select(int id){
        Ammunition ammunition = null;
        ammunitions.removeAll(Collections.singleton(null));
        for (Ammunition a: ammunitions){
            if (a.getId() == id){
                ammunition = a;
            }
        }
        return ammunition;
    }

        public ArrayList<Ammunition> sortByWeight(){
        ArrayList<Ammunition> sortedByWeight = new ArrayList<>(ammunitions);
        sortedByWeight.removeAll(Collections.singleton(null));
        sortedByWeight.sort(Comparator.comparing(Ammunition::getWeight));
        return sortedByWeight;
    }
}