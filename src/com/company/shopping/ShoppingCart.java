package com.company.shopping;

import com.company.clothes.Ammunition;
import com.company.person.Human;

import java.util.ArrayList;

public class ShoppingCart {
    private Human human;
    private ArrayList<Ammunition> ammunitions;
    private final Shop shop;

    public ShoppingCart(Human human, Shop shop) {
        this.human = human;
        this.shop = shop;
        ammunitions = new ArrayList<>();
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public ArrayList<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public void add(Ammunition ammunition) {
        ammunitions.add(ammunition);
    }

    public double getSum() {
        double cost = 0;
        for (Ammunition a: ammunitions){
            if(a != null) {
                cost += a.getPrice();
            }
        }
        System.out.printf("Overall cost: %.2f$", cost);
        return cost;
    }

    public void buyAll(){
        human.getWardrobe().addToWardrobe(ammunitions);
    }
}
