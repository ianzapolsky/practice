// Main.java

// Description: Write a program to sort a stack in ascending order (with
// biggest items on top). You may use additional stacks, but no other data
// structures apart from that. Stacks support push, pop, peek, and empty.

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        

        Stack<Integer> s = new Stack<Integer>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        s = sortStack(s);      
        System.out.println(s);
    }

    public static Stack<Integer> sortStack(Stack<Integer> s) {
        
        Stack<Integer> sorted = new Stack<Integer>();

        if (s.empty() == true)
            return sorted;

    
        // We're bascially mimmicking insertion sort here, stripping the
        // minimum element off the list each time. O(n^2)?
        while (s.empty() == false) 
            sorted.push(min(s));

        return sorted;
    }

    public static Integer min(Stack s) {
       
        Stack<Integer> helper = new Stack<Integer>();
        Integer min, cur;
        min = null;
        boolean taken = false;

        while (s.empty() == false) {
            cur = (Integer)(s.pop());
            if (min == null)
                min = cur;
            else if (cur < min)
                min = cur; 
            System.out.println("cur is "+cur+", min is "+min);
            helper.push(cur);
        }

        // At this point we know the minimum value that was originally in s.
        // All values that were in s are now stored in reverse in order in
        // helper, so let's copy them back to s, with the exception of the
        // minimum value. Added boolean variable taken to handle duplicates.

        while (helper.empty() == false) {
            cur = (Integer)(helper.pop());
            if (cur == min && taken == false)
                taken = true;
            else 
                s.push(cur);
        }
        
        // Now helper is empty, s is exactly how we found it, order intact,
        // minus its smallest element, which we now return. 
        return min;
    }
}            








        
            
        
