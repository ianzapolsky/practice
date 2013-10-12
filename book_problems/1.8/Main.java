// Main.java -- Book Problem 1.8

// description: Use one call to isSubstring() to find out if s2 is a rotation
// of s1. e.g. "waterbottle" is a rotation of "terbottlewa".
// author: Ian Zapolsky (10/09/13)

public class Main {

    // Check if str2 is a substring of str1.
    public static boolean isSubstring(String str1, String str2) {

        if (str2.length() > str1.length())
            return false;

        for (int i = 0; i+str2.length() < str1.length(); i++) {
            if (str1.substring(i, i+str2.length()).equalsIgnoreCase(str2))
                return true;
        }
        
        return false;
    }

    // Check if str2 is a rotation of str1 using one call to isSubstring().
    public static boolean isRotation(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;
        
        String doubleStr1 = str1+""+str1;
        if (isSubstring(doubleStr1, str2))
            return true;
        return false;
    }

    public static void main(String[] args) {
        
        String str1 = "waterbottle";
        String str2 = "erbottlewat";
        System.out.println(isRotation(str1, str2));
    
    }
}
