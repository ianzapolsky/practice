// SetOfStacks.java

// Description: Expanding and contracting set of Stacks.
// Author: Ian Zapolsky (10/23/13)

import java.util.ArrayList;

public class SetOfStacks {

    final int THRESHOLD = 10;
    ArrayList<Stack> setOfStacks;
    int current_stack;
    
    public SetOfStacks() {
        setOfStacks = new ArrayList<Stack>();
        setOfStacks.add(new Stack(THRESHOLD));
        current_stack = 0;
    }

    public void push(int data) {
        if (setOfStacks.get(current_stack).isFull()) {
            current_stack += 1;
            setOfStacks.add(new Stack(THRESHOLD));
            push(data); 
        }
        else {
            System.out.println("pushed "+data+" onto stack "+current_stack);
            setOfStacks.get(current_stack).push(data);
        }
    }

    public Integer pop() {
        if (current_stack < 0) 
            return null;
        else {
            Integer popped_value = setOfStacks.get(current_stack).pop();
            if (popped_value == null) {
                current_stack -= 1;
                return pop(); 
            }
            else {
                System.out.println("popped from stack "+current_stack);
                return popped_value;
            }
        }
    }

}
            
        
