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
        for (Ammunition a: ammunitions){
            if (a.getId() == id){
                ammunition = a;
            }
        }
        return ammunition;
    }

        public ArrayList<Ammunition> sortByWeight(){
        ArrayList<Ammunition> sortedByWeight = new ArrayList<>(ammunitions);
//        Collections.sort(sortedByWeight, new Comparator<Ammunition>(){
//            public int compare(Ammunition o1, Ammunition o2) {
//                if (o1.getWeight().equals(null)) {
//                    return (o2.getWeight().equals(null)) ? 0 : -1;
//                }
//                if (o2.getWeight().equals(null)) {
//                    return 1;
//                }
//                return o2.getWeight().compareTo(o1.getWeight());
//            }
//        });
        sortedByWeight.sort(Comparator.comparing(Ammunition::getWeight));
        System.out.println("Sorted by weight: ");
        for (Ammunition a: sortedByWeight){
            System.out.println(a.getName() + " " + a.getWeight());
        }
        return sortedByWeight;
    }
}