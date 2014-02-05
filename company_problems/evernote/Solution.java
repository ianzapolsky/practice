/* 
 * Solution to the frequency counting of words question for Evernote
 * by Ian Zapolsky (01/24/14)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      
        ArrayList<String> seen = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        // read all lines in O(n) time, impossible to speed up

        for (int i = 0; i < n; i++) {
            String tmp = in.nextLine();
            if (map.get(tmp) != null) 
                map.put(tmp, map.get(tmp)+1);
            else {
                map.put(tmp, 1);
                seen.add(tmp);
            }
        }

        int k = Integer.parseInt(in.nextLine());

        // this is n^2 gross

        for (int i = 0; i < k; i++) {
            int max = 0;
            String frequent = "";
            for (String s : seen) {
                if (map.get(s) > max) {
                    max = map.get(s);
                    frequent = s; 
                } else if (map.get(s) == max) {
                    if (s.compareTo(frequent) > 0) 
                        frequent = s;
                }
            }
            seen.remove(frequent);
            map.remove(frequent);
            System.out.println(frequent);
        }
    }
}
        
        
