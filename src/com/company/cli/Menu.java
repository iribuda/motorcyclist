package com.company.cli;

import com.company.clothes.Ammunition;
import com.company.dressing.DressUp;
import com.company.dressing.Wardrobe;
import com.company.person.Human;
import com.company.person.Motorcyclist;
import com.company.shopping.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    private Human human;
    private Shop shop;
    private ShoppingCart shoppingCart;
    private Wardrobe wardrobe;
    private DressUp dressUp;

    public Menu(){
        this.human = new Motorcyclist("Adis", "0220075870", "Male", 20);
        this.shop = new Shop();
        this.shoppingCart = new ShoppingCart(human, shop);
        this.wardrobe = human.getWardrobe();
        this.dressUp = new DressUp(human);
    }

    public void showMainMenu(){
        System.out.println("====================");
        System.out.println("Main Menu");
        System.out.println("1 - register" +
                "\n2 - shop menu" +
                "\n3 - show wardrobe" +
                "\n4 - dress up" +
                "\n5 - show ammunition that is on" +
                "\n0 - exit");
        System.out.print(">>> Enter the option: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        switch (number){
            case 1:
                register();
                break;
            case 2:
                shoppingMenu();
                break;
            case 3:
                showWardrobe();
                break;
            case 4:
                selectForDressing();
                break;
            case 5:
                showAmmunitionOn();
                break;
            default:
                break;
        }
    }

    public void register(){
        System.out.print(">>> Enter your name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.print(">>> Enter your age: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.print(">>> Enter your phoneNumber: ");
        String number = in.nextLine();
        System.out.print(">>> Enter your gender: ");
        String gender = in.nextLine();

        human = new Motorcyclist(name, number, gender, age);
        showMainMenu();
    }

    public void shoppingMenu(){
        System.out.println("====================");
        System.out.println("Shopping Cart Menu");
        System.out.println("1 - show items in shop" +
                "\n2 - show certain items in shop" +
                "\n3 - show items in price range" +
                "\n4 - show my shopping cart" +
                "\n5 - add items to shopping cart" +
                "\n6 - buy all" +
                "\n0 - back to main menu");
        System.out.print(">>> Enter the option: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        switch (number){
            case 1:
                showShop();
                break;
            case 2:
                showFilteredShop();
                break;
            case 3:
                showItemsInPriceRange();
                break;
            case 4:
                showCart();
                break;
            case 5:
                addToCart();
                break;
            case 6:
                buyAllInCart();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                break;
        }
    }

    public void showShop(){
        System.out.println("====================");
        System.out.println("Here is our shop! You can choose items you need.");
        System.out.printf("%3s %16s %8s %8s", "id", "name", "weight", "price");
        for (Ammunition a: shop.getAmmunitions()){
            System.out.printf("\n%3d %16s %8.1fkg %8.2f$", a.getId(), a.getName(), a.getWeight(), a.getPrice());
        }
        System.out.println();
        shoppingMenu();
    }

    public void showFilteredShop(){
        System.out.println("====================");
        System.out.println("You can filter out the items in our shop by categories. We have: " +
                "\n1 - helmet" +
                "\n2 - jacket" +
                "\n3 - gloves" +
                "\n4 - pants" +
                "\n5 - boots");
        System.out.print(">>> Choose the number of category you need: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        ArrayList<Ammunition> filteredAmmunition = new ArrayList<>();
        switch (number){
            case 1:
                filteredAmmunition = shop.filterAmmunition(new AmmunitionIsHelmet());
                break;
            case 2:
                filteredAmmunition = shop.filterAmmunition(new AmmunitionIsJacket());
                break;
            case 3:
                filteredAmmunition = shop.filterAmmunition(new AmmunitionIsGloves());
                break;
            case 4:
                filteredAmmunition = shop.filterAmmunition(new AmmunitionIsPants());
                break;
            case 5:
                filteredAmmunition = shop.filterAmmunition(new AmmunitionIsBoots());
                break;
            default:
                break;
        }
        printAmmunitionWithPrice(filteredAmmunition);
        shoppingMenu();
    }

    public void showItemsInPriceRange(){
        Scanner in = new Scanner(System.in);
        System.out.println("====================");
        System.out.print(">>> Enter the min price: ");
        double min = in.nextDouble();
        System.out.print(">>> Enter the max price: ");
        double max = in.nextDouble();
        System.out.println("Items that cost more than " + min + "$ and less than " + max + "$");
        printAmmunitionWithPrice(shop.findByPriceRange(min, max));
        shoppingMenu();
    }

    public void addToCart(){
        System.out.println("====================");
        System.out.println("Adding to cart");
        Scanner in = new Scanner(System.in);
        int i=1;
        do{
            System.out.print("\n>>>Enter the id of item you want to buy. If you are done, press 0: ");
            i = in.nextInt();
            shoppingCart.add(shop.select(i));
        }while (i!=0);
        shoppingMenu();
    }

    public void buyAllInCart(){
        System.out.println("====================");
        System.out.print(">>> Do you want to buy everything? (y/n) ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        switch (answer){
            case "y":
                shoppingCart.getSum();
                shoppingCart.buyAll();
                System.out.println("\nYou successfully bought everything! Now you can check it in your wardrobe");
                break;
            case "n":
                shoppingMenu();
                break;
            default:
                break;
        }
        shoppingMenu();
    }

    public void showCart(){
        System.out.println("====================");
        System.out.println("Everything you added to the cart");
        printAmmunitionWithPrice(shoppingCart.getAmmunitions());
        shoppingMenu();
    }

    public void showWardrobe(){
        System.out.println("====================");
        System.out.println("Everything you have in your wardrobe");
       printAmmunitionWithoutPrice(wardrobe.getAmmunitions());
        System.out.print("\n>>> Do you want to sort out your wardrobe by weight? (y/n) ");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        switch (answer){
            case "y":
                showSortedWardrobe();
                break;
            case "n":
                showMainMenu();
                break;
            default:
                break;
        }
    }

    public void showSortedWardrobe(){
        System.out.println("====================");
        System.out.println("Everything you have in your wardrobe sorted by weight");
        printAmmunitionWithoutPrice(wardrobe.sortByWeight());
        showMainMenu();
    }

    public void selectForDressing(){
        System.out.println("====================");
        System.out.println("Dressing up");
        Scanner in = new Scanner(System.in);
        int i=0;
        do{
            System.out.print("\n>>>Enter the id of item you want to put on. If you are done, press 0: ");
            i = in.nextInt();
            dressUp.putOn(wardrobe.select(i));
        }while (i!=0);
        showMainMenu();
    }

    public void showAmmunitionOn(){
        System.out.println("====================");
        System.out.println("Everything you are in");
        printAmmunitionWithoutPrice(dressUp.showAmmunitionOn());
    }

    public void printAmmunitionWithPrice(ArrayList<Ammunition> ammunitions){
        ammunitions.removeAll(Collections.singleton(null));
        System.out.printf("%3s %16s %8s %8s", "id", "name", "weight", "price");
        for (Ammunition a: ammunitions){
            System.out.printf("\n%3d %16s %8.1fkg %8.2f$", a.getId(), a.getName(), a.getWeight(), a.getPrice());
        }
        System.out.println();
    }

    public void printAmmunitionWithoutPrice(ArrayList<Ammunition> ammunitions){
        ammunitions.removeAll(Collections.singleton(null));
        System.out.printf("%3s %16s %8s", "id", "name", "weight");
        for (Ammunition a: ammunitions){
            System.out.printf("\n%3d %16s %8.1fkg", a.getId(), a.getName(), a.getWeight());
        }
        System.out.println();
    }
}
