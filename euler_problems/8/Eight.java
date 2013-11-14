// Eight.java

// Description: Find the greatest product of 5 consecutive digits in a
// 1000-digit number.
// Author: Ian Zapolsky

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Eight {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(
                                new InputStreamReader(System.in));
        
        String number = "";
        for (int i = 0; i < 20; i++)
            number += br.readLine();
        
        System.out.println(number);
        System.out.println("\n\n");
        System.out.println(findLargestConsecutiveN(5, number));
    }

    public static int findLargestConsecutiveN(int n, String number) {
        
        if (n > number.length())
            return -1;

        int maxProduct = 0;
        for (int i = 0; i < number.length()-n; i++) {
            String factors = number.substring(i, i+n);
            int result = multiply(factors);
            System.out.println(factors+" "+result);
            if (result > maxProduct)
                maxProduct = result; 
        }
        return maxProduct;
    }

    public static int multiply(String number) {
        int product = 1;
       
        for (int i = 0; i < number.length(); i++) {
            product *= Integer.valueOf(number.charAt(i))-'0';
        }
        return product;
    }
            



} 

