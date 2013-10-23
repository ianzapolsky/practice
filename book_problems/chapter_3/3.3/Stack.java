// Stack.java

// Description: Basic integer array implementation of a stack for 3.3
// Author: Ian Zapolsky (10/23/13)

public class Stack {
    
    int[] stack;
    int top, size;

    public Stack(int init_size) {
        size = init_size;
        stack = new int[size];
        top = 0; }

    public Integer pop() {
        if (top == 0)
            return null;
        else 
            top -= 1;
            return stack[top];
    }

    public void push(int data) {
        if (top == size) return;
        else stack[top++] = data; }

    public boolean isFull() {
        return (top == size); }

}
