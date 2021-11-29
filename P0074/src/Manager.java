/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bảo Châu
 */
public class Manager {
    
    public int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
        int [][] newMat = new int [matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMat[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return newMat;
    }

    public int[][] subMatrix(int[][] matrix1, int[][] matrix2) {
        int [][] newMat = new int [matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMat[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return newMat;
    }

    public int[][] mulMatrix(int[][] matrix1, int[][] matrix2) {
        int [][] newMat = new int [matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    newMat[i][j] = newMat[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return newMat;
    }
    
}
