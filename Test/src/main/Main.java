/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import utils.Utils;
/**
 *
 * @author Bảo Châu
 */
public class Main {

    public static void main(String[] args) {
        // declare
        Utils utils = new Utils();
        int arr[];
        String cont;
        Scanner sc = new Scanner(System.in);

        do {
            // insert size of array
            int insNum = utils.insertNum();
            arr = new int[insNum];
            // random number then insert into array
            arr = utils.randNum(insNum);
            // sort array by Bubble Sort
            utils.bubbleSort(arr);

            // continue or not
            System.out.print("Do you want to continue (y/other)? ");
            cont = sc.nextLine();
        } while (cont.equalsIgnoreCase("y"));
    }
}
