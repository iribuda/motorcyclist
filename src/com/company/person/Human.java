package com.company.person;

import com.company.clothes.Ammunition;
import com.company.dressing.Wardrobe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public abstract class Human {
    private String name, phoneNumber, gender;
    private Integer age;
    private Wardrobe wardrobe;
    private Set<Ammunition> ammunitionOn;

    public Human(String name, String phoneNumber, String gender, Integer age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        setWardrobe();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Wardrobe getWardrobe() {
        return wardrobe;
    }

    public void setWardrobe() {
        wardrobe = new Wardrobe();
    }

    public Set<Ammunition> getAmmunitionOn() {
        return ammunitionOn;
    }

    public void setAmmunitionOn(Ammunition ammunition) {
        this.ammunitionOn.add(ammunition);
    }

    //    public void setAmmunition(Ammunition ammunition){
//        ammunitions.add(ammunition);
//    }
//
//    public double getSum() {
//        double cost = 0;
//        for (Ammunition a: ammunitions){
//            cost += a.getPrice();
//        }
//        System.out.println("Cost: " + cost);
//        return cost;
//    }
//
//    public ArrayList<Ammunition> sortByWeight(){
//        ArrayList<Ammunition> sortedByWeight = new ArrayList<>(ammunitions);
//        Collections.sort(sortedByWeight, new Comparator<Ammunition>(){
//            public int compare(Ammunition o1, Ammunition o2)
//            {
//                if(o1.getWeight()<o2.getWeight()){
//                    return -1;
//                }
//                else if(o1.getWeight()>o2.getWeight()){
//                    return 1;
//                }
//                else{
//                    return 0;
//                }
//            }
//        });
//        System.out.println("Sorted by weight: ");
//        for (Ammunition a: sortedByWeight){
//            System.out.println(a.getName() + " " + a.getWeight());
//        }
//        return sortedByWeight;
//    }
//
//    public ArrayList<Ammunition> findByPriceRange(double min, double max){
//        ArrayList<Ammunition> requiredAmmunitions = new ArrayList<>();
//        System.out.println("Ammunition in price range from " + min + " to " + max + " :");
//        for(Ammunition a: ammunitions){
//            if (a.getPrice()>=min && a.getPrice()<=max){
//                requiredAmmunitions.add(a);
//                System.out.println(a.getName() + " " + a.getPrice());
//            }
//        }
//        return requiredAmmunitions;
//    }

}
