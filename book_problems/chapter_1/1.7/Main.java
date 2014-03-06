// Main.java -- Book Problem 1.7

// description: Write an algorithm that scans through a matrix and sets a
// column/row to 0 if it finds an element in that column/row that is 0.
// author: Ian Zapolsky (10/09/13)

import java.util.ArrayList;

public class Main {

    // This algorithm first scans the entire matrix, searching for 0s and
    // flagging the columns and rows that contain 0s. It then goes back
    // and zeroes out any flagged columns and rows.
    // O(n^2), O(1) --> doesn't use any space

    public static void setZeros(int[][] matrix) {
        
        int n = matrix[0].length;
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> cols = new ArrayList<Integer>();
        
        // Preliminary scan, so as to avoid setting the entire matrix to 0.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                    // could we add a break statement here to minimally improve
                    // efficiency?
                }
            }
        }
        
        // Go back and set the appropriate rows and columns to 0.
        for (int row : rows) {
            for (int i = 0; i < n; i++)
                matrix[row][i] = 0;
        }
        for (int col : cols) {
            for (int i = 0; i < n; i++)
                matrix[i][col] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
       
        for (int[] row : matrix) {
            for (int i : row) 
                System.out.println(i);
        } 
    }

    public static void main(String[] args) {

        int[][] matrix = {{0,1,2},{3,4,5},{6,7,8}};
        printMatrix(matrix);
        setZeros(matrix);
        printMatrix(matrix);
    }
}
        
        
