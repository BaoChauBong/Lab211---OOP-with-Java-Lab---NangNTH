import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers sc Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template sc the editor.
 */
/**
 *
 * @author Bảo Châu
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    //check user input a number integer
    private static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }
//allow user input number of array

    private static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }
    //allow user input value of array

    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = checkInputInt();


        }
        return a;
    }

    private static int[] RandomArray(int n) {
        Random ran = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ran.nextInt(100);
        }
        return a;
    }
        //sort array by bubble sort
    private static void sortArrayByBubbleSort(int[] a) {

        System.out.print("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("");
            display(a);
        }
        System.out.println();
    }

    //display array after sort
    private static void display(int[] a) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = RandomArray(n);
        sortArrayByBubbleSort(a);
        System.out.print("Sorted array: ");
        display(a);
    }

}