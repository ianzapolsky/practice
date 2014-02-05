/*
 * MinHeap
 * insert: O(log(n))
 * find: O(log(n))
 * min: O(1)
*/

public class MinHeap {

    private int[] heap;
    private int ptr;

    public MinHeap(int initial_capacity) 
    {
        heap = new int[initial_capacity];
        ptr = 0;
    }

    public void insert(int data)
    {
        heap[ptr] = data;
        bubbleUp(ptr);
        ptr += 1;
    }

    public int popMin() 
    {
        int result = heap[0];
        heap[0] = Integer.MAX_VALUE;
        bubbleDown(0);
        return result;
    }
        
      
    private void bubbleUp(int current_index)
    {
        if (heap[current_index] < heap[getParent(current_index)])
        {
            int temp = heap[current_index];
            heap[current_index] = heap[getParent(current_index)];
            heap[getParent(current_index)] = temp;
            bubbleUp(getParent(current_index));
        }
    }

    private void bubbleDown(int current_index)
    {
        if (getLeftChild(current_index) >= heap.length || 
            getRightChild(current_index) >= heap.length)
        {
            return;
        }
        if (heap[getLeftChild(current_index)] < heap[getRightChild(current_index)])
        {
            if (heap[getLeftChild(current_index)] < heap[current_index])
            {
                int temp = heap[current_index];
                heap[current_index] = heap[getLeftChild(current_index)];
                heap[getLeftChild(current_index)] = temp;
                bubbleDown(getLeftChild(current_index));
            }
        } else 
        {
            if (heap[getRightChild(current_index)] < heap[current_index])
            {
                int temp = heap[current_index];
                heap[current_index] = heap[getRightChild(current_index)];
                heap[getRightChild(current_index)] = temp;
                bubbleDown(getRightChild(current_index));
            }
        }
    }

    private int getParent(int child_index)
    {
        return child_index/2;
    }

    private int getLeftChild(int parent_index)
    {
        return parent_index*2;
    }

    private int getRightChild(int parent_index)
    {
        return (parent_index*2)+1;
    }
}






     
