/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bảo Châu
 */
public class Utils {

    // declare
    Scanner sc = new Scanner(System.in);
    int arr[];

    // check number
    public int checkInsNum() {
        while (true) {
            try {
                int checkedNum = Integer.parseInt(sc.nextLine().trim());
                if (checkedNum < 0) {
                    throw new NumberFormatException();
                } else {
                    return checkedNum;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a POSITIVE NUMBER again!");
                System.out.print("Enter number of Array: ");
            }
        }
    }

    // insert number
    public int insertNum() {
        int insNum = 0;

        System.out.print("Enter number of Array: ");
        insNum = checkInsNum();

        return insNum;
    }

    // random number into array
    public int[] randNum(int insNum) {
        arr = new int[insNum];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        System.out.println("Unsorted Array: " + Arrays.toString(arr));

        return arr;
    }

    // bubble sort
    public void bubbleSort(int arr[]) {
        //number of passes
        for (int i = 0; i < arr.length - 1; i++) {
            //keeps track of positions per pass  
            for (int j = 0; j < arr.length - i - 1; j++) {
                //if left value is great than right value 
                if (arr[j] > arr[j + 1]) {
                    //swap values
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}