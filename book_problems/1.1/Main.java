// Main.java -- Book Problem 1.1  

// description: implement an algorithm to determine if a string has all unique
// characters. What if you cannot use additional data structures?
// author: Ian Zapolsky (10/01/13)

import java.util.HashMap;

public class Main {

    public static boolean hasRepeat_HashMap(String input) {
    // Method to determine if a string has any repeat characters. Stores seen
    // characters in a HashMap.
    // O(n), O(n)
        
        if (input.length() <= 1)
            return false;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (map.get(input.charAt(i)) != null)
                return true;
            map.put(input.charAt(i), 1);
        }
        return false;
    }

    public static boolean hasRepeat_Array(String input) {
    // Uses an array of all ASCII character values to check for repeats.
    // O(n), O(1)

        boolean[] values = new boolean[256];
        for (int i = 0; i < input.length(); i++) {
            int charVal =  input.charAt(i);
            if (values[charVal] == true)
                return true;
            values[charVal] = true;
        }
        return false;
    }
    
    public static boolean hasRepeat_BitVector(String input) {
    // Uses a bit vector to do the same as above, with a 8x less space
    // O(n), O(1)
    
        if (input.length() <= 1)
          return false;
        else if (input.length() > 256)
            return true;
        
        int bit = 0;
        for (int i = 0; i < input.length(); i++) {
            int charVal = input.charAt(i) - 'a';
            if ((bit & (1 << charVal)) > 0)
                return true;
            bit |= (1 << charVal);
        }
        return false;        
    }

    public static void main(String[] args) {

        assert hasRepeat_HashMap("apple") == true;
        assert hasRepeat_HashMap("orange") == false;
        assert hasRepeat_Array("apple") == true;
        assert hasRepeat_Array("orange") == false;
        assert hasRepeat_BitVector("apple") == true;
        assert hasRepeat_BitVector("orange") == false;
        System.out.println("tests passed");

    }

}

