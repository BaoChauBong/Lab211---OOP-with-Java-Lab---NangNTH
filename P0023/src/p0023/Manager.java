/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0023;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Admin
 */
public class Manager {
    public static int menu(){
        System.out.println("1.  Create Fruit");
        System.out.println("2.  View orders");
        System.out.println("3.  Shopping (for buyer)");
        System.out.println("4.  Exit");
        
        System.out.println("Enter your choice: ");
        int choice = Checking.checkInputLimit(1, 4);
        return choice;
    }
    
    public static void createFruit (ArrayList<Fruit> ls){
        while(true){
            System.out.print("Fruit ID: ");
            String fruitId = Checking.checkString();
            // check ID exist
            if (!Checking.checkIdExist(ls, fruitId)){
                System.err.println("ID exist! ");
                return;
            }
            System.out.print("Fruit Name: ");
            String fruitName = Checking.checkString();
            System.out.print("Price: ");
            double price = Checking.checkDouble();
            System.out.print("Quantity: ");
            int quan = Checking.checkInt();
            System.out.print("Origin: ");
            String origin = Checking.checkString();
            
            ls.add(new Fruit(fruitId, fruitName, price, quan, origin));
            if (!Checking.checkInputYN()){
                return;
            }
        }
    }
    
    // Show Order
    public static void viewOrder (Hashtable<String, ArrayList<Order>> ht){
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList <Order> lo = ht.get(name);
            displayOrder(lo);
        }
    }

    public static void displayOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(), order.getQuantity()
            , order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }
    
    public static void buyItem(ArrayList<Fruit> ls, Hashtable<String, ArrayList<Order>> ht){
        if (ls.isEmpty()){
            System.err.println("Don't have Item! ");
            return;
        }
        ArrayList<Order> lo = new ArrayList<>();
        while (true){
            displayFruit(ls);
            System.out.print("Item: ");
            int item = Checking.checkInputLimit(1, ls.size());
            Fruit fruit = getFruitByItem(ls, item);
            System.out.print("Quantity: ");
            int quantity = Checking.checkInputLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            
            // check item exist or not
            if (!Checking.checkItemExist(lo, fruit.getFruitId())){
                updateOrder (lo, fruit.getFruitId(), quantity);
            }
            else {
                lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(), quantity, fruit.getPrice()));
            }
            if (!Checking.checkInputYN()){
                break;
            }
        }
        displayOrder(lo);
        System.out.print("Name: ");
        String name = Checking.checkString();
        ht.put(name, lo);
        System.err.println("Add successful! ");
        }
    
    private static void displayFruit(ArrayList<Fruit> ls) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fr : ls) {
            if (fr.getQuantity() != 0){
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++, 
                        fr.getFruitName(), fr.getOrigin(), fr.getPrice());
            }
        }
    }
    
    // Get fruit want to buy
    private static Fruit getFruitByItem(ArrayList<Fruit> ls, int item) {
        int countItem = 1;
        for (Fruit fr : ls) {
            if (fr.getQuantity() != 0){
                countItem++;
            }
            if (countItem - 1 == item){
                return fr;
            }
        }
        return null;
    }

    private static void updateOrder(ArrayList<Order> lo, String fruitId, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(fruitId)){
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}
