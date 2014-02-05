// Stack.java

// Description: Basic integer array implementation of a stack for 3.4
// Author: Ian Zapolsky (10/23/13)

public class Stack {
    
    String name;
    int[] stack;
    int top, size;

    public Stack(int init_size, String init_name) {
        name = init_name;
        size = init_size;
        stack = new int[size];
        top = 0;
    }

    public Integer pop() {
        if (top == 0)
            return null;
        else 
            top -= 1;
            return stack[top];
    }

    public void push(int data) {
        if (top == size) return;
        else stack[top++] = data;
    }

    public boolean isFull() {
        return (top == size);
    }

    public void moveTopTo(Stack s) {
        int top = pop();
        s.push(top);
        System.out.println("moved "+top+" from "+name+" to "+s.name);
    }
    
    public void moveDisks(int n, Stack destination, Stack buffer) {
        if (n > 0) {
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < top; i++)
            result+=stack[i]+",";
        return result;
    }
        
}

