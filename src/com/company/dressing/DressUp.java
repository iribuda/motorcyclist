package com.company.dressing;

import com.company.clothes.Ammunition;
import com.company.person.Human;
import com.company.shopping.AmmunitionFilter;

import java.util.ArrayList;

public class DressUp {

    private Human human;

    public DressUp(Human human) {
        this.human = human;
    }

    public Human putOn(Ammunition ammunition){
        human.setAmmunitionOn(ammunition);
        return human;
    }

    public ArrayList<Ammunition> sortAmmunition(AmmunitionFilter ammunitionFilter){
        ArrayList<Ammunition> sortedAmmunition = new ArrayList<>();
        for (Ammunition ammunition: human.getWardrobe().getAmmunitions()){
            if (ammunitionFilter.check(ammunition)){
                sortedAmmunition.add(ammunition);
            }
        }
        return sortedAmmunition;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
