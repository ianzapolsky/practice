// MyQueue.java

// Description: Implement a queue using two stacks.
// Author: Ian Zapolsky (10/26/13)

import java.util.Stack;

public class MyQueue {

    public Stack<Integer> s1, s2;
    
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int data) { s1.push(data); }

    public Integer pop() {

        // Copy s1 to s2 to reverse the order of the elements.
        while (s1.empty() == false)
            s2.push(s1.pop());

        // The "top" element in s2 will be the first element that was added
        // to s1. Save this as first_in_line.
        int first_in_line = s2.pop();

        // Copy s2 back to s1 to preserve order for future pushes.
        while (s2.empty() == false) 
            s1.push(s2.pop());

        // Return first in line
        return first_in_line;
    }
}
    
