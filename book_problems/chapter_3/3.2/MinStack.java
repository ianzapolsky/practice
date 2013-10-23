// MinStack.java

// Description: Linked list implementation of a Stack that provides O(1) push,
// pop, and min.
// Author: Ian Zapolsky (10/23/13)

public class MinStack {

    MinStackNode top;
    
    public MinStack() {
        top = null;
    }

    public void push(int data) {
        MinStackNode new_node = new MinStackNode();
        new_node.data = data;

        if (top == null)
            new_node.min_below = new_node.data;
        else
            new_node.min_below = Math.min(data, top.min_below);
        new_node.next = top;
        top = new_node;
    }

    public Integer pop() {
        if (top == null)
            return null;
        MinStackNode popped = top;
        top = top.next;
        return popped.data;
    }

    public Integer min() {
        return top.min_below;
    }
}
        
       
