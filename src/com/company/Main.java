package com.company;

import com.company.clothes.*;
import com.company.person.Motorcyclist;

public class Main {

    public static void main(String[] args) {

        Motorcyclist motorcyclist1 = new Motorcyclist("Adis", "0220078570", "Male", 20);
        Boots boots1 = new Boots("Good boots", 10.99, 2);
        Gloves gloves1 = new Gloves("Good gloves", 5.49, 1);
        Helmet helmet1 = new Helmet("Good helmet", 12.29, 3);
        Jacket jacket1 = new Jacket("Good jacket", 15.59, 2);
        Pants pants1 = new Pants("Good pants", 11.99, 2);
        motorcyclist1.setAmmunition(boots1);
        motorcyclist1.setAmmunition(gloves1);
        motorcyclist1.setAmmunition(helmet1);
        motorcyclist1.setAmmunition(jacket1);
        motorcyclist1.setAmmunition(pants1);

        motorcyclist1.getSum();
        System.out.println("========");
        motorcyclist1.sortByWeight();
        System.out.println("========");
        motorcyclist1.findByPriceRange(10, 14);
    }
}
