// Main.java -- Book Problem 1.5

// description: Implement a method to perform basic string compression using
// the counts of repeated characters: "aabccccaaa" becomes "a2b1c4a3". If the
// compressed String is not shorter than the original, return the original.
// author: Ian Zapolsky (10/09/13)

public class Main {

    public static String compressString(String str) {

        // Length check.
        if (str.length() <= 1)
            return str;

        String result = "";
        
        // Compress str.
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            int count = 1;
            while (i+1 < str.length()) {
                if (current == str.charAt(i+1)) {
                    i += 1;
                    count += 1;
                }
                else
                    break;
            }
            result += String.valueOf(current)+""+count;
        }

        // If result is not shorter than str, return str. 
        if (result.length() > str.length())
            return str;

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(compressString("aabccccaaa"));
    }

}


        
