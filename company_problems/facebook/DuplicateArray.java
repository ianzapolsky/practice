// DuplicateArray.java

// Author: Ian Zapolsky (10/30/13)

import java.util.HashMap;

public class DuplicateArray {

    public static void main(String[] args) {

        int[] test = {1,2,3,2,1,4};
        System.out.println(printArray(test));
        System.out.println(printArray(removeDuplicates(test)));

    }

    public static String printArray(int[] input) {
        String result = "";
        for (int i : input) 
            result += i+" ";
        return result;
    }
        

    public static int[] removeDuplicates(int[] input) {
    
        int[] result = new int[input.length];
        int result_ptr = 0;
        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
        

        for (int i : input) {
            if (seen.get(i) != null)
                /* do nothing */;
            else {
                result[result_ptr++] = i;
                seen.put(i, i);
            }
        }

        return result;
    }
}
