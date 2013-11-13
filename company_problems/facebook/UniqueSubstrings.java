// UniqueSubstrings.java

// Description: Return the number of unique substrings in an input string.
// Author: Ian Zapolsky (11/13/13)

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class UniqueSubstrings {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.next();

        System.out.println(findUniqueSubstrings(input));
    }

    public static int findUniqueSubstrings(String str) {
    
        HashMap<String, String> seenStrings = new HashMap<String, String>();
        int uniqueSubstrings = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (seenStrings.get(substring) != null)
                    /* do nothing */;
                else {
                    seenStrings.put(substring, substring);
                    uniqueSubstrings += 1;
                }
            }
        }
        return uniqueSubstrings;
    }
}
        
