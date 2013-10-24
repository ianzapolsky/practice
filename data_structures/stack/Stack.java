// Stack.java

// Description: Implementation of generic stack using an array
// Author: Ian Zapolsky (10/20/13)

public class Stack<T> {
    
    public T[] stack;
    public int size;
    public int step;
    public int top;

    public Stack() {
        
        // Start with space for 100 as a baseline.
        size = 10;
        step = 10;
        stack = (T[])new Object[size];
        top = 0;
    }

    public void push(T data) {
        stack[top] = data;
        increment();
    }

    public T pop() {
        if ( (top -= 1) < 0)
            return null;
        T popped = stack[top];
        return popped;
    }

    public void increment() {
        if (top == size-1) {
            size += step;
            T[] temp = (T[])new Object[size];
            for (int i = 0; i < size-100; i++)
                temp[i] = stack[i];
            stack = temp;
        }
        top += 1;
    }
}
