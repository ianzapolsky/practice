// find the "breaking point" of an integer array, or the point when the sum
// of the elements at indexes 0 - br.pt. == the sum of the elements at indexes
// br.pt.+1 - n-1.

public class Main {

    public static void main(String[] args) {
    
        int[] array1 = {1,2,3,4,5,2,5,4,4};
        int[] array2 = {1,0,-1,-1,1};

        System.out.println(findBreakingPoint(array1));
        System.out.println(findBreakingPoint(array2));
    }

    public static int findBreakingPoint(int[] array) {

        int left_sum = 0;
        int right_sum = 0;

        // sum entire array
        for (int i : array)
            right_sum += i;

        // search left to right for breaking point
        for (int i = 0; i < array.length; i++) {
            left_sum += array[i];
            right_sum -= array[i];
            if (left_sum == right_sum)
                return i;
        }

        // return -1 in the event that no breaking point exists
        return -1;
    }
}
