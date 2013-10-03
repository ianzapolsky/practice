// Main.java -- POJ Problem #1002
// author: Ian Zapolsky (10/2/13)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static String cleanTelephoneNumber(String dirtyNumber) {
        
        String result = "";
        for (int i = 0; i < dirtyNumber.length(); i++) {
            char c = dirtyNumber.charAt(i);
            if (c == '-')
                continue;
            else if (c >= '0' && c <= '9')
                result += String.valueOf(c);
            else
                result += convertLetter(c);
        }
        return result;

    }

    public static String convertLetter(char letter) {
      
        if (letter - 'A' < 3)
            return "2";
        else if (letter - 'A' < 6)
            return "3";
        else if (letter - 'A' < 9)
            return "4";
        else if (letter - 'A' < 12)
            return "5";
        else if (letter - 'A' < 15)
            return "6";
        else if (letter - 'A' < 19)
            return "7";
        else if (letter - 'A' < 22)
            return "8";
        else
            return "9";
        
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(in.readLine());

        HashMap<String, Integer> phonebook = new HashMap<String, Integer>();
        ArrayList<String> duplicates = new ArrayList<String>();

        while (inputSize-- > 0) {
            String tmp = in.readLine();
            String cur = cleanTelephoneNumber(tmp);
            Integer occurrences = phonebook.get(cur);
            if (occurrences == null)
                phonebook.put(cur, 1);
            else
                phonebook.put(cur, occurrences+1);
        }

        for (String s : phonebook.keySet()) {
            if (phonebook.get(s) > 1)
                duplicates.add(s);
        }

        Collections.sort(duplicates);

        if (duplicates.size() == 0)
            System.out.println("No duplicates.");
        else {
            for (String s : duplicates) 
                System.out.println(
                    s.substring(0,3)+"-"+s.substring(3,s.length())+" "+phonebook.get(s));
        }
    }
}

 
            

