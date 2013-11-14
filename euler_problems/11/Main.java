// Main.java

// Description: Find the four adjacent numbers that multiply to the largest
// product in a 20x20 grid read in from stdin.
// Author: Ian Zapolsky (11/14/13)

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        // Build grid as 2D array from stdin
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) 
                grid[row][col] = in.nextInt();
        }
       
        // Print greatest product of x factors to stdout
        System.out.println(findMaxProduct(grid, 4));
    }

    public static int findMaxProduct(int[][] grid, int factors) {
        return Math.max(findMaxProductHoriVert(grid, factors),
                        findMaxProductDiag(grid, factors));
    }

    public static int findMaxProductHoriVert(int[][] grid, int factors) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i < grid.length - (factors-1))
                    max = Math.max(max, multiplyStraight(grid, factors, j, i));
                if (j < grid.length - (factors-1))
                    max = Math.max(max, multiplyStraight(grid, factors, i, j));
            }
        }
        return max;
    }
    
    public static int multiplyStraight(int[][] grid, int factors, int row,
                                         int col) {
        int result = 1;
        for (int k = 0; factors-- > 0; k++)
            result *= grid[row][col+k];
        return result;
    }

    public static int findMaxProductDiag(int[][] grid, int factors) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i < grid.length - (factors-1) && j < grid[i].length - (factors-1))
                    max = Math.max(max, multiplyDiagonalLeft(grid, factors, i, j));
                if (i < grid.length - (factors-1) && j >= factors-1)
                    max = Math.max(max, multiplyDiagonalRight(grid, factors, i, j));
            }
        }
        return max;
    }

    public static int multiplyDiagonalLeft(int[][] grid, int factors, int row,
                                           int col) {
        int result = 1;
        for (int k = 0; factors-- > 0; k++)
            result *= grid[row+k][col+k];
        return result;
    }
    
    public static int multiplyDiagonalRight(int[][] grid, int factors, int row,
                                            int col) {
        int result = 1;
        for (int k = 0; factors-- > 0; k++)
            result *= grid[row+k][col-k];
        return result;
    } 
}
                     
    
