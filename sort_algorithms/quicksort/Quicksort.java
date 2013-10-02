// Quicksort.java
// by Ian Zapolsky (10/01/13)

import java.util.Random;

public class Quicksort {

    final int ARRAY_SIZE = 10;
    final int UPPER_BOUND = 1000;

    public static void main(String[] args) {
    
        Quicksort q = new Quicksort();

        int[] array = q.generateArray();
        q.printArray(array);

        System.out.println("sorting...");

        q.quicksort(array);
        q.printArray(array);
    }

    public Quicksort() { }

    public int[] generateArray() {
    // generates array of size ARRAY_SIZE filled with random numbers from 
    // 1 - UPPER_BOUND

        int[] array = new int[ARRAY_SIZE];
        Random rand = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++)
            array[i] = (rand.nextInt(UPPER_BOUND)+1);
        return array;
    }
        
    public void quicksort(int[] array) {
        quicksort(array, 0, array.length-1);
    }

    private void quicksort(int[] array, int begIndex, int endIndex) {
    // quicksort algorithm with in-place partitioning

        if (endIndex <= begIndex)
            return;

        int pivotIndex = (begIndex+endIndex)/2;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, endIndex);

        int cur = begIndex;
        for (int i = begIndex; i < endIndex; i++) {
            if (array[i] < pivot) {
                swap(array, cur, i);
                cur++;
            }
        }

        swap(array, cur, endIndex);
        pivotIndex = cur;
        quicksort(array, begIndex, pivotIndex-1);
        quicksort(array, pivotIndex+1, endIndex);
    }
        
    private void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public void printArray(int[] array) {
        if (array.length == 0)
            System.out.println("empty");
        else {
            String result = "";
            for (int i : array)
                result += (i+", ");
            System.out.println(result);
        }
    }

}
     






