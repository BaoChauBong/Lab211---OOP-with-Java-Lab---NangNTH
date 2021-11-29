/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0023;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Checking {
    private static final Scanner sc = new Scanner (System.in);
    
    public static int checkInputLimit (int a, int b){
        while(true){
            try{
                int re = Integer.parseInt(sc.nextLine().trim());
                if (re < a || re > b){
                    throw new NumberFormatException();
                }
                return re;
            }
            catch (NumberFormatException e){
                System.err.println("Enter number from " + a + " to " + b);
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkString(){
        while(true){
            String re = sc.nextLine().trim();
            if (re.isEmpty()){
                System.err.println("Not empty! ");
                System.out.print("Enter again: ");
            }
            else {
                return re;
            }
        }
    }
    
    public static int checkInt(){
        while(true){
            try{
                int re = Integer.parseInt(sc.nextLine().trim());
                return re;
            }
            catch (NumberFormatException e){
                System.err.println("Please enter integer number! ");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static double checkDouble(){
        while(true){
            try{
                double re = Double.parseDouble(sc.nextLine().trim());
                return re;
            }
            catch (NumberFormatException e){
                System.err.println("Please enter integer number! ");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static boolean checkInputYN(){
        System.out.print("Do you want to continue (Y/N) ?");
        while(true){
            String re = checkString();
            if (re.equalsIgnoreCase("Y")){
                return true;
            }
            if (re.equalsIgnoreCase("N")){
                return false;
            }
            System.err.println("Please input Y or N");
            System.out.print("Enter again: ");
        }
    }
    
    // Check ID exist or not
    public static boolean checkIdExist(ArrayList<Fruit> ls, String id){
        for (Fruit fr : ls) {
            if (id.equalsIgnoreCase(fr.getFruitId())){
                return false;
            }
        }
        return true;
    }
    
    // Check ITEM exist or not
    public static boolean checkItemExist(ArrayList<Order> lo, String id){
        for (Order order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)){
                return false;
            }
        }
        return true;
    }
}
