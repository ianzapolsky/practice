// TripleStack.java

// Description: Implements three separate dynamic stacks on one integer array.
// Author: Ian Zapolsky (10/23/13)

public class TripleStack {
    
    final int SIZE = 30;
    int[] array;
    
    int 1start, 2start, 3start;
    int 1ptr, 2ptr, 3ptr;

    public TripleStack() {
        array = new int[SIZE];
        1start = 1ptr = 0;
        2start = 2ptr = SIZE/3;
        3start = 3ptr = 2start+(SIZE/3);
    }

    public void push(int stack, int data) {
        if (stack < 1 || stack > 3)
            return;
        if (stack == 1) 
            array[1ptr++] = data;
        else if (stack == 2) 
            array[2ptr++] = data;
        else 
            array[3ptr++] = data;
        if (1ptr == (1start+(SIZE/3)) || 2ptr == (2start+(SIZE/3)) ||
            3ptr == (3start+(SIZE/3)))
            increaseSize();
    }

    public Integer pop(int stack, int data) {
        if (stack < 1 || stack > 3)
            return null;
        
        
            

