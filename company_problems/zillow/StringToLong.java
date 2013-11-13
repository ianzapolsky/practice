// StringToLong.java

// Description: Write a function that takes a String as input and converts it
// to the primitive type long.
// Author: Ian Zapolsky (11/12/13)

public class StringToLong {

    public static void main(String[] args) {
        
        String test = "12345";
        long result = convert(test);
        System.out.println(result);
    }

    public static long convert(String input) {

        long result = 0;
        int power = 0;
        for (int i = input.length()-1; i >= 0; i--) {
            result += Math.pow(10, power)*(input.charAt(i)-'0');
            power += 1;
        }
        return result;
    }
}
