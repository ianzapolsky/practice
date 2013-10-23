// Main.java

// Description: Implement SetOfStacks, which implements O(1) push/pop on a set
// of fixed-size stacks. When a stack becomes full a new stack is added to
// the set, when a stack becomes empty it is removed.
// Author: Ian Zapolsky

public class Main {
    
    public static void main(String[] args) throws Exception {

        SetOfStacks s = new SetOfStacks();
        for (int i = 0; i < 25; i++)
            s.push(i);
        for (int i = 0; i < 25; i++)
            System.out.println(s.pop());
    }

}
