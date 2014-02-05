/*
 * Main.java
 * Write a program that finds the longest palindromic substring of a given
 * string.
 * By Ian Zapolsky (12/07/13)
*/

public class Main {

    public static void main(String[] args) {
        String test = "glassart";
        System.out.println(find_longest_palindromic_substring(test));
    }

    public static String find_longest_palindromic_substring(String str) {
        String result = "";
        for (int i = 1; i < str.length()-1; i++) {
            for (int j = 1; i-j >= 0 && i+j < str.length(); j++) { 
                // even check
                if (str.charAt(i) == str.charAt(i+j)) {
                    if (str.substring(i, i+1).length() > result.length())
                        result = str.substring(i, i+1);
                } 
            // odd check
            if (str.charAt(i-1)
      

    
