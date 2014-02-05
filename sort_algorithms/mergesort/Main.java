// Main.java 

// Description: Mergesort algorithm implemented to sort an array.
// Author: Ian Zapolsky (10/14/13)

import java.util.Random;

public class Main {

    // Merges the contents of arr1 and arr2 into a sorted ascending array.
    // O(n), O(1) 
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[(arr1.length+arr2.length)]; 
        int arr1_ptr = 0, arr2_ptr = 0, result_ptr = 0;
    
        while (arr1_ptr < arr1.length && arr2_ptr < arr2.length) {
            if (arr1[arr1_ptr] < arr2[arr2_ptr])
                result[result_ptr++] = arr1[arr1_ptr++];
            else
                result[result_ptr++] = arr2[arr2_ptr++];
        } 
        if (arr1_ptr < arr1.length) {
            while (arr1_ptr < arr1.length)
                result[result_ptr++] = arr1[arr1_ptr++];
        } else {
            while (arr2_ptr < arr2.length)
                result[result_ptr++] = arr2[arr2_ptr++];
        }

        return result;
    }
     
    // Recursively splits arr up into smaller and smaller pieces (called log(n)
    // times) and then merges them back together in a sorted manner.
    // O(n log(n)), O(n)
    public static int[] mergesort(int[] arr) {
        if (arr.length <= 1)
            return arr;
    
        int midpoint = arr.length/2;
        int[] left = new int[midpoint];
        int[] right = new int[arr.length-midpoint];

        for (int i = 0; i < midpoint; i++)
            left[i] = arr[i];
        for (int i = 0; i < (arr.length-midpoint); i++)
            right[i] = arr[i+midpoint];

        return merge(mergesort(left), mergesort(right));  
    }

    public static void main(String[] args) {

        System.out.print("ready... ");  

        Random random = new Random();
        int test[] = new int[10000000];
        for (int i = 0; i < 10000000; i++)
            test[i] = random.nextInt();
        
        System.out.println("go ->");
  
        test = mergesort(test);

        System.out.println("done");
  
    }
}



        
        
        
        
               
        

