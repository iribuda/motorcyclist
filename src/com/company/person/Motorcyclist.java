package com.company.person;

import com.company.clothes.Ammunition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Motorcyclist extends Human{

    private ArrayList<Ammunition> ammunitions = new ArrayList<>();

    public Motorcyclist(String name, String phoneNumber, String gender, Integer age) {
        super(name, phoneNumber, gender, age);
    }

    public void setAmmunition(Ammunition ammunition){
        ammunitions.add(ammunition);
    }

    public double getSum() {
        double cost = 0;
        for (Ammunition a: ammunitions){
            cost += a.getPrice();
        }
        System.out.println("Cost: " + cost);
        return cost;
    }

    public ArrayList<Ammunition> sortByWeight(){
        ArrayList<Ammunition> sortedByWeight = new ArrayList<>(ammunitions);
        Collections.sort(sortedByWeight, new Comparator<Ammunition>(){
            public int compare(Ammunition o1, Ammunition o2)
            {
                if(o1.getWeight()<o2.getWeight()){
                    return -1;
                }
                else if(o1.getWeight()>o2.getWeight()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });
        System.out.println("Sorted by weight: ");
        for (Ammunition a: sortedByWeight){
            System.out.println(a.getName() + " " + a.getWeight());
        }
        return sortedByWeight;
    }

    public ArrayList<Ammunition> findByPriceRange(double min, double max){
        ArrayList<Ammunition> requiredAmmunitions = new ArrayList<>();
        System.out.println("Ammunition in price range from " + min + " to " + max + " :");
        for(Ammunition a: ammunitions){
            if (a.getPrice()>=min && a.getPrice()<=max){
                requiredAmmunitions.add(a);
                System.out.println(a.getName() + " " + a.getPrice());
            }
        }
        return requiredAmmunitions;
    }
}
