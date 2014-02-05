/*
 * Speller
 * Takes a list of desired messages and outputs their telephone keypress 
 * sequences
 * Ian Zapolsky (01/01/14)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Speller {

    private int n;
    private HashMap<Character, String> keypad;
    private ArrayList<String> messages;
    private Scanner in;

    public Speller() {
        in = new Scanner(System.in);
        initKeypad();
    }

    public void processInput() {
        read();
        outputKeypresses();
    }

    private void initKeypad() {

        keypad = new HashMap<Character, String>();
        keypad.put('a', "2");
        keypad.put('b', "22");
        keypad.put('c', "222");
        keypad.put('d', "3");
        keypad.put('e', "33");
        keypad.put('f', "333");
        keypad.put('g', "4");
        keypad.put('h', "44");
        keypad.put('i', "444");
        keypad.put('j', "5");
        keypad.put('k', "55");
        keypad.put('l', "555");
        keypad.put('m', "6");
        keypad.put('n', "66");
        keypad.put('o', "666");
        keypad.put('p', "7");
        keypad.put('q', "77");
        keypad.put('r', "777");
        keypad.put('s', "7777");
        keypad.put('t', "8");
        keypad.put('u', "88");
        keypad.put('v', "888");
        keypad.put('w', "9");
        keypad.put('x', "99");
        keypad.put('y', "999");
        keypad.put('z', "9999");
        keypad.put(' ', "0");
    }
  
    private int getKey(char character) {

        if (character == ' ')
            return 0;
        else if ((character)-'a' < 3)
            return 2;
        else if ((character)-'a' < 6)
            return 3;
        else if ((character)-'a' < 9)
            return 4;
        else if ((character)-'a' < 12)
            return 5;
        else if ((character)-'a' < 15)
            return 6;
        else if ((character)-'a' < 19)
            return 7;
        else if ((character)-'a' < 22)
            return 8;
        else
            return 8;
    }
      
    private void read() {
        n = Integer.parseInt(in.nextLine());
        messages = new ArrayList<String>(); 
        for (int line = 0; line < n; line++) 
            messages.add(in.nextLine());
    }
            
    private void outputKeypresses() {
        int count = 1;
        for (String message : messages) {
            String output = "Case #"+(count++)+": ";
            output += process(message);
            System.out.println(output);
        }
    }

    private String process(String message) {

        String output = "";
        int prev = 1;
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (prev == getKey(currentChar))
                output += " ";
            output += keypad.get(currentChar);
            prev = getKey(currentChar);
        }
        return output;
    }

}
        
        
