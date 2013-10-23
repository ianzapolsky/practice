// Main.java

// Description: Implement a stack with O(1) pop, push, and min.
// Author: Ian Zapolsky (10/23/13)

public class Main {
    
    public static void main(String[] args) {
        
        MinStack s = new MinStack();
        
        for (int i = 2; i < 20; i++) 
            s.push(i);
        System.out.println(s.min());
        for (int i = 1; i < 40; i++) 
            s.push(i);
        System.out.println(s.min());
    }
}
            
