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
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Fruit> ls = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        
        while (true){
            int choice = Manager.menu();
            switch(choice){
                case 1:
                    Manager.createFruit(ls);
                    break;
                case 2:
                    Manager.viewOrder(ht);
                    break;
                case 3:
                    Manager.buyItem(ls, ht);
                    break;
                case 4:
                    break;
            }
        }
    }
}
