// Main.java -- Book Problem 1.6

// description: Given an NxN matrix containing some image, rotate it 90
// degrees.
// author: Ian Zapolsky (10/09/13)

public class Main {

    // Rotate the matrix -90 degrees if direction = 0, +90 degrees if direction
    // = 1. This algorithm does not operate in place.
    // O(n^2), O(n)
    public static int[][] rotateMatrix(int[][] matrix, int direction) {
        
        int n = matrix[0].length;
        int[][] rotated_matrix = new int[n][n];

        int rot_row, rot_col;

        if (direction == 0) {
            rot_row = (n-1);
            rot_col = 0;
        } else {
            rot_row = 0;
            rot_col = (n-1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated_matrix[rot_row][rot_col] = matrix[i][j];
                if (direction == 0) {
                    if (rot_row == 0) {
                        rot_row = (n-1);
                        rot_col += 1;
                    } else 
                        rot_row -= 1;
                } else {
                    if (rot_row == (n-1)) {
                        rot_row = 0;
                        rot_col -= 1;
                    } else 
                        rot_row += 1;
                }
            }
        }

        return rotated_matrix;
    }

    public static void printMatrix(int[][] matrix) {
    
        for (int[] column : matrix) {
            for (int i : column)
                System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2},{3,4,5},{6,7,8}};
        printMatrix(matrix);
        printMatrix(rotateMatrix(matrix, 0));
    }
}
        
        







