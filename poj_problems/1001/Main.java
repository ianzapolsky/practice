// Main.java -- POJ Problem #1001

// description: given 0.00 < R <= 99.99 and 0 < n <= 25, output the exact value
// of R^n without leading zeros, trailing zeros, or decimal points if the
// answer is an integer
// author: Ian Zapolsky (10/02/13)

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.math.BigDecimal;

public class Main {
    
    public static void calculatePair(BigDecimal R, int n) {

        BigDecimal result = new BigDecimal("1.0");
        for (int i = 0; i < n; i++)
            result = result.multiply(R);
        System.out.println(
            removeLeadingZeros(result.stripTrailingZeros().toPlainString()));
    }
     
    public static String removeLeadingZeros(String input) {
        if (input.charAt(0) == '0')
            return input.substring(1, input.length());
        return input;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(new BufferedInputStream(System.in));

        while (scan.hasNext()) {
            BigDecimal R = scan.nextBigDecimal();
            int n = scan.nextInt();                
            calculatePair(R, n);
        }

    }            
}
    

