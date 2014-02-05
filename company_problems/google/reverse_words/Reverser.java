/*
 * Reverser
 * Given a list of space separated words, reverse the order of the words.
 * Ian Zapolsky (12/31/13)
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reverser {

    private int n;
    private Scanner in;
    private ArrayList<Stack<String>> lineStacks;
    
    public Reverser() {

        in = new Scanner(System.in);
        lineStacks = new ArrayList<Stack<String>>();
    }

    public void readAndReverse() {
  
        read();
        outputReverse();
        in.close();

    }    

    private void read() {

        n = Integer.parseInt(in.nextLine());
        // number of test cases

        for (int line = 0; line < n; line++) {

            Stack<String> wordstack = new Stack<String>();
            // store words in stack, so we can give reverse order in O(n) time
      
            String currentLine = in.nextLine();
            Scanner lineScanner = new Scanner(currentLine);
            while (lineScanner.hasNext())
                wordstack.push(lineScanner.next());

            lineStacks.add(wordstack);
            // add the stack of words of the current line to lineStacks
        }
    }

    private void outputReverse() {
  
        for (int line = 0; line < n; line++) {
            
            String output = "Case #"+(line+1)+":";
            while (!lineStacks.get(line).empty())
                output += " "+lineStacks.get(line).pop();
            System.out.println(output);
        }
    }

}
