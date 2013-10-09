// Main.java -- Book Problem 1.3

// description: Given two strings, write a method to decide if one is a
// permutation of the other
// author: Ian Zapolsky (10/07/13)

public class Main {

    public static boolean isPermutation(String str, String check) {
    // Method to determine if two strings, str and check, are permutations of
    // one another. Uses an integer array of size 256 to keep track of the
    // number of characters that have been seen.
    // O(n), O(1)
    
        // Initial length check.
        if (check.length() != str.length())
            return false;
        
        // Create character array.
        int[] characters = new int[256];
    
        // Seed character array with str.
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            characters[val] += 1;
        }

        // Alter character array with check.
        for (int i = 0; i < check.length(); i++) {
            int val = check.charAt(i);
            characters[val] -= 1;
        }

        // Run through and check for values not 0.
        for (int i = 0; i < 256; i++) {
            if (characters[i] != 0)
                return false;
        }
        
        return true;
    }

    // We could improve efficiency by sorting (using quicksort or mergesort,
    // the O(nlogn) sorting algorithms) and then directly comparing them for
    // equality. This would reduce the time complexity but almost increase the
    // space complexity.

    public static void main(String[] args) {
        System.out.println(isPermutation("test", "stte"));
        System.out.println(isPermutation("test", "sste"));
        
    }
}

