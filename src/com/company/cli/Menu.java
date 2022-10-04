package com.company.cli;

import com.company.clothes.Ammunition;
import com.company.dressing.DressUp;
import com.company.dressing.Wardrobe;
import com.company.person.Human;
import com.company.person.Motorcyclist;
import com.company.shopping.Shop;
import com.company.shopping.ShoppingCart;

import java.util.Scanner;

public class Menu {
    private Human human;
    private Shop shop;
    private ShoppingCart shoppingCart;
    private Wardrobe wardrobe;

    public Menu(){
        this.human = new Motorcyclist("Adis", "0220075870", "Male", 20);
        this.shop = new Shop();
        this.shoppingCart = new ShoppingCart(human, shop);
        this.wardrobe = human.getWardrobe();
    }

    public Human getHuman() {
        return human;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
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
        System.out.printf("%3s %16s %8s %8s", "id", "name", "weight", "price");
        for (Ammunition a: shoppingCart.getAmmunitions()){
            if (a!=null) {
                System.out.printf("\n%3d %16s %8.1fkg %8.2f$", a.getId(), a.getName(), a.getWeight(), a.getPrice());
            }
        }
        System.out.println();
        shoppingMenu();
    }

    public void shoppingMenu(){
        System.out.println("====================");
        System.out.println("Shopping Cart Menu");
        System.out.println("1 - show items in shop" +
                "\n2 - show my shopping cart" +
                "\n3 - add items to shopping cart" +
                "\n4 - buy all" +
                "\n0 - back to main menu");
        System.out.print(">>> Enter the option: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        switch (number){
            case 1:
                showShop();
                break;
            case 2:
                showCart();
                break;
            case 3:
                addToCart();
                break;
            case 4:
                buyAllInCart();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                break;
        }
    }

    public void showWardrobe(){
        System.out.println("====================");
        System.out.println("Everything you have in your wardrobe");
        System.out.printf("%3s %16s %8s", "id", "name", "weight");
        for (Ammunition a: wardrobe.getAmmunitions()){
            if (a != null) {
                System.out.printf("\n%3d %16s %8.1fkg", a.getId(), a.getName(), a.getWeight());
            }
        }
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
        System.out.printf("%3s %16s %8s %8s", "id", "name", "weight", "price");
        for (Ammunition a: wardrobe.sortByWeight()){
            if (a != null) {
                System.out.printf("\n%3d %16s %8.1fkg", a.getId(), a.getName(), a.getWeight());
            }
        }
    }

    public void selectForDressing(){
        System.out.println("====================");
        System.out.println("Dressing up");
        Scanner in = new Scanner(System.in);
        int i=0;
        DressUp dressUp = new DressUp(human);
        do{
            System.out.print("\n>>>Enter the id of item you want to put on. If you are done, press 0");
            i = in.nextInt();
            dressUp.putOn(wardrobe.select(i));
        }while (i!=0);
    }

    public void showAmmunitionOn(){
        System.out.println("====================");
        System.out.println("Everything you are in");
        System.out.printf("%3s %16s %8s %8s", "id", "name", "weight", "price");
        for (Ammunition a: human.getAmmunitionOn()){
            System.out.printf("\n%3d %16s %8.1fkg", a.getId(), a.getName(), a.getWeight());
        }
    }
}
