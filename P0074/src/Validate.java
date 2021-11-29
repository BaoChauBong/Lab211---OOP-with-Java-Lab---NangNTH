
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bảo Châu
 */
public class Validate {
    Manager m = new Manager();
    
    public static final Scanner sc = new Scanner (System.in);
    public void menu() {
        System.out.println("======== Calculator Program ========");
        System.out.println("1.  Addition Matrix");
        System.out.println("2.  Subtraction Matrix");
        System.out.println("3.  Multiplication Matrix");
        System.out.println("4.  Quit");
    }
    
    public int getInputInt(String mess, String err, int min, int max){
        int num;
        while (true){
            try{
                System.out.print(mess);
                num = Integer.parseInt(sc.nextLine());
                if (num < min || num > max){
                    System.out.println(err);
                }
                else {
                    return num;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Must be number! ");
            }
        }
    }
    
    public void run(){
        while (true){
            menu();
            int choice = getInputInt("Your choice: ", "Chosing only 1 - 4", 1, 4);
            if (choice == 4){
                System.exit(0);
            }
            matrixHandling(choice);
            System.out.println();
        }
    }

    public void matrixHandling(int choice) {
        // Matrix 1
        int row1 = getInputInt("Enter Row Matrix 1: ", "Out of range! ", 1, Integer.MAX_VALUE);
        int col1 = getInputInt("Enter Column Matrix 1: ", "Out of range! ", 1, Integer.MAX_VALUE);
        int [][] mt1 = newMatrix(row1, col1);
        
        int row2, col2;
        // Row of matrix 2
        while(true){
            row2 = getInputInt("Enter Row Matrix 2: ", "Out of range! ", 1, Integer.MAX_VALUE);
            if (choice != 3){
                if (row2 != row1){
                    System.out.println("The matrix must be same size! ");
                    return;
                }
                else {
                    break;
                }
            }
            else {
                if (row2 != col1){
                    System.out.println("Row of Matrix 2 must be equal Column of Matrix 1");
                    return;
                }
                else {
                    break;
                }
            }
        }
        
        // Col of matrix 2
        while (true){
            col2 = getInputInt("Enter Column Matrix 1: ", "Out of range! ", 1, Integer.MAX_VALUE);
            if (choice != 3){
                if (col2 != col1){
                    System.out.println("The matrix must be same size! ");
                    
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        
        // Matrix 2
        int [][] mt2 = newMatrix(row2, col2);
        int [][] re;
        switch (choice){
            case 1:
                re = m.addMatrix(mt1, mt2);
                displayResult(mt1, mt2, re, choice);
                break;
            case 2:
                re = m.subMatrix(mt1, mt2);
                displayResult(mt1, mt2, re, choice);
                break;
            case 3:
                re = m.mulMatrix(mt1, mt2);
                displayResult(mt1, mt2, re, choice);
                break;
        }
    }

    public int[][] newMatrix(int row, int col) {
        int [][] newMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMatrix[i][j] = getInputInt(String.format("Enter Matrix [%d][%d] ", i+1, j+1), "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return newMatrix;
    }

    public void displayResult(int[][] mt1, int[][] mt2, int[][] re, int choice) {
        System.out.println("---------- Result ----------");
        displayMatrix(mt1);
        switch (choice){
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("x");
                break;
        }
        displayMatrix(mt2);
        System.out.println("=");
        displayMatrix(re);
    }
    
    public void displayMatrix(int[][] mt) {
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt[0].length; j++) {
                System.out.print("[" + mt[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    

}
