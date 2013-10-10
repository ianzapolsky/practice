// Main.java -- Book Problem 1.4

// description: Given a String, replace all spaces with "%20". e.g. "john
// smith     " becomes "john%20smith"
// author: Ian Zapolsky (10/09/13)

public class Main {

    public static String replaceWhitespace(String str) {

        char[] str_chars = str.toCharArray();
        String result = "";

        // Eliminate trailing whitespace.
        int trail = str_chars.length-1;
        while (str_chars[trail] == ' ') {
            str_chars = str.substring(0, trail).toCharArray();
            trail -= 1;
        }
        
        // Replace all whitespace characters with "%20".
        for (char c : str_chars) {
            if (c == ' ')
                result += "%20";
            else
                result += String.valueOf(c);
        }

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(replaceWhitespace("john smith   "));
    }

}


        
