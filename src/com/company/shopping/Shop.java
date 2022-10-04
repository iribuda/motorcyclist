package com.company.shopping;

import com.company.clothes.*;

import java.util.ArrayList;

public class Shop {
    ArrayList<Ammunition> ammunitions = new ArrayList<>();

    public Shop(){
        loadItems();
    }

    public void loadItems(){
        Boots boots1 = new Boots(1, "Good boots", 10.99, 1.5);
        Boots boots2 = new Boots(2, "Great boots", 16.99, 1.0);
        Boots boots3 = new Boots(3, "Normal boots", 6.99, 1.8);
        Gloves gloves1 = new Gloves(4, "Good gloves", 5.99, 0.5);
        Gloves gloves2 = new Gloves(5, "Great gloves", 7.49, 0.4);
        Gloves gloves3 = new Gloves(6, "Standard gloves", 3.59, 0.4);
        Helmet helmet1 = new Helmet(7, "Good helmet", 10.99, 1.5);
        Helmet helmet2 = new Helmet(8, "Great helmet", 16.99, 1.3);
        Helmet helmet3 = new Helmet(9, "Normal helmet", 8.19, 1.9);
        Jacket jacket1 = new Jacket(10, "Good jacket", 15.89, 2.0);
        Jacket jacket2 = new Jacket(11, "Great jacket", 18.99, 1.8);
        Jacket jacket3 = new Jacket(12, "Standard jacket", 11.79, 2.2);
        Pants pants1 = new Pants(13, "Good pants", 8.99, 1.5);
        Pants pants2 = new Pants(14, "Great pants", 10.29, 1.2);
        Pants pants3 = new Pants(15, "Normal pants", 5.99, 1.4);

        ammunitions.add(boots1);
        ammunitions.add(boots2);
        ammunitions.add(boots3);
        ammunitions.add(gloves1);
        ammunitions.add(gloves2);
        ammunitions.add(gloves3);
        ammunitions.add(helmet1);
        ammunitions.add(helmet2);
        ammunitions.add(helmet3);
        ammunitions.add(jacket1);
        ammunitions.add(jacket2);
        ammunitions.add(jacket3);
        ammunitions.add(pants1);
        ammunitions.add(pants2);
        ammunitions.add(pants3);
    }

    public ArrayList<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public ArrayList<Ammunition> filterAmmunition(AmmunitionFilter ammunitionFilter){
        ArrayList<Ammunition> filteredAmmunition = new ArrayList<>();
        for (Ammunition ammunition: ammunitions){
            if (ammunitionFilter.check(ammunition)){
                filteredAmmunition.add(ammunition);
            }
        }
        return filteredAmmunition;
    }

    public ArrayList<Ammunition> findByPriceRange(double min, double max){
        ArrayList<Ammunition> ammunitionsInRange = new ArrayList<>();
        System.out.println("Ammunition in price range from " + min + " to " + max + " :");
        for(Ammunition a: ammunitions){
            if (a.getPrice()>=min && a.getPrice()<=max){
                ammunitionsInRange.add(a);
                System.out.println(a.getName() + " " + a.getPrice());
            }
        }
        return ammunitionsInRange;
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
}
