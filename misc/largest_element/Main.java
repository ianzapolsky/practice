// Main.java
// Various functions that return the largest element in a list.
// By Ian Zapolsky (12/08/13)

public class Main {

    public static void main(String[] args) {
  
        int[] list = {10,6,8,7,3,11};
        System.out.println(findLargestLinear(list));
        System.out.println(findLargestWithMergesort(list));  
  
    }


    // O(n) runtime, just run through the list one item at a time with a max
    // value placeholder.
    public static int findLargestLinear(int[] list) {
        int max = 0;
        for (int integer : list) {
            if (integer > max)
                max = integer;
        }
        return max;
    }

    // O(nlogn) runtime, we sort the list with mergesort first, then return
    // the largest element.
    public static int findLargestWithMergesort(int[] list) {
        mergesort(list, 0, list.length-1);
        for (int i : list)
            System.out.println(i);
        return list[list.length-1];
    }
    

    // in-place mergesort
    public static void mergesort(int[] list, int begin, int end) {
        if ((end-begin) < 1)
            return;
        int midpoint = (begin + end)/2;
        mergesort(list, begin, midpoint);
        mergesort(list, (midpoint+1), end);
        merge(list, begin, midpoint, end);
    }

    public static void merge(int[] list, int begin, int midpoint, int end) {
        int ptr1 = begin;
        int ptr2 = midpoint+1;
        
        while (ptr1 <= midpoint && ptr2 <= end) {
            if (list[ptr1] <= list[ptr2]) {
                ptr1 += 1;
            } else {
                int temp = list[ptr2];
                for (int i = ptr2-1; i >= ptr1; i--)
                    list[i+1] = list[i];
                list[ptr1] = temp;
                ptr2 += 1;
            }
        }
    }
                
}







        
        
        



        
