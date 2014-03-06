// Three Arrays Problem
// Desc: Given three sorted (ascending) arrays of variable length
// find the median of integers contained in the three arrays.

import java.util.Random;

public class ThreeArrays {

	public static void main(String[] args) {

		// vars for function timing.
		long start;
		long end;

		int median;

		int[] arr1 = createNewSortedArray(100000);
		int[] arr2 = createNewSortedArray(100000);
		int[] arr3 = createNewSortedArray(100000);

		start = System.nanoTime();
		median = findMedianOfThree1(arr1, arr2, arr3);
		end = System.nanoTime();

		System.out.println("median: "+median+" found in "+(end-start)+" ns.");

		start = System.nanoTime();
		median = findMedianOfThree2(arr1, arr2, arr3);
		end = System.nanoTime();

		System.out.println("median: "+median+" found in "+(end-start)+" ns.");
	}

	public static int[] createNewSortedArray(int size) {

		Random r = new Random();	
		int[] result = new int[size];

		int startVal = r.nextInt(1000);
		result[0] = startVal;

		for (int i = 1; i < size; i++) 
			result[i] = result[i-1] + r.nextInt(1000);

		return result;
	}

	// redistribute the list into a bigger list, then find the median
	// O(N)-time, O(N)-space
	public static int findMedianOfThree1(int[] arr1, int[] arr2, int[] arr3) {

		int[] merged = new int[arr1.length+arr2.length+arr3.length];
		int mergedPtr = 0;

		int ptr1 = 0;
		int ptr2 = 0;
		int ptr3 = 0;

		while (ptr1 >= 0 || ptr2 >= 0 || ptr3 >= 0) {

			int nextBiggest = Integer.MAX_VALUE;
			int origin = 0;

			if (ptr1 >= 0) {
				if (arr1[ptr1] <= nextBiggest) {
					nextBiggest = arr1[ptr1];
					origin = 1;
				}
			}
			if (ptr2 >= 0) {
				if (arr2[ptr2] <= nextBiggest) {
					nextBiggest = arr2[ptr2];
					origin = 2;
				}
			}
			if (ptr3 >= 0) {
				if (arr3[ptr3] <= nextBiggest) {
					nextBiggest = arr3[ptr3];
					origin = 3;
				}
			}

			// if we find that any ptr has reached the end of its
			// array, we set to -1 to indicate that it is invalid.
			if (origin == 1) {
				if (ptr1+1 == arr1.length)
					ptr1 = -1;
				else ptr1 += 1;
			} else if (origin == 2) {
				if (ptr2+1 == arr2.length)
					ptr2 = -1;
				else ptr2 += 1;
			} else {
				if (ptr3+1 == arr3.length)
					ptr3 = -1;
				else ptr3 += 1;
			}				

			merged[mergedPtr] = nextBiggest;
			mergedPtr += 1;
		}

		// return the middle element for arrays with odd number of
		// elements, return the average of the two middle elements
		// for arrays with even number of elements.
		if (merged.length % 2 != 0) 
			return merged[merged.length/2];
		else
			return (merged[merged.length/2]+merged[(merged.length/2)-1])/2;
	}

	// find the median of the three lists in place
	// O(N)-time, O(1)-space 
	public static int findMedianOfThree2(int[] arr1, int[] arr2, int[] arr3) {

		int median = 0;

		int size = arr1.length+arr2.length+arr3.length;
		int count = 0;

		int ptr1 = 0;
		int ptr2 = 0;
		int ptr3 = 0;

		while (count <= size/2) {

			int nextBiggest = Integer.MAX_VALUE;
			int origin = 0;

			if (ptr1 >= 0) {
				if (arr1[ptr1] <= nextBiggest) {
					nextBiggest = arr1[ptr1];
					origin = 1;
				}
			}
			if (ptr2 >= 0) {
				if (arr2[ptr2] <= nextBiggest) {
					nextBiggest = arr2[ptr2];
					origin = 2;
				}
			}
			if (ptr3 >= 0) {
				if (arr3[ptr3] <= nextBiggest) {
					nextBiggest = arr3[ptr3];
					origin = 3;
				}
			}

			// if we find that any ptr has reached the end of its
			// array, we set to -1 to indicate that it is invalid.
			if (origin == 1) {
				if (ptr1+1 == arr1.length)
					ptr1 = -1;
				else ptr1 += 1;
			} else if (origin == 2) {
				if (ptr2+1 == arr2.length)
					ptr2 = -1;
				else ptr2 += 1;
			} else {
				if (ptr3+1 == arr3.length)
					ptr3 = -1;
				else ptr3 += 1;
			}	

			if (size % 2 == 0 && count == (size/2)-1)
				median += nextBiggest;
			if (count == (size/2))
				median += nextBiggest;

			count += 1;
		}

		if (size % 2 == 0)
			median = median/2;

		return median;
	}

	public static int findMedianOfThree3(int[] arr1, int start1, int end1,
										 int[] arr2, int start2, int end2, 
										 int[] arr3, int start3, int end3) {

		int median1 = findMedianWithBound(arr1, start1, end1);
		int median2 = findMedianWithBound(arr2, start2, end2);
		int median3 = findMedianWithBound(arr3, start3, end3);

		// shrink the bounds of the array with the biggest median
		if (median1 >= median2 && median1 >= median3) {
			for (int i = end1; i >= start1; i--)	{
				if (arr1[i] <= median1) {
					end1 = i;
					break;
				}
			}
		} else if (median2 >= median1 && median2 >= median3) {
			for (int i = end2; i >= start2; i--)	{
				if (arr2[i] <= median2) {
					end2 = i;
					break;
				}
			}	
		} else {
			for (int i = end3; i >= start3; i--)	{
				if (arr3[i] <= median3) {
					end3 = i;
					break;
				}
			}
		}

		// shrink the bounds of the array with the smallest median
		if (median1 <= median2 && median1 <= median3) {
			int 
		} else if (median2 <= median1 && median2 <= median3) {

		} else {

		}

		return findMedianOfThree3(arr1, start1, end1,
								  arr2, start2, end2,
								  arr3, start3, end3);

	}

	public static int findMedianWithBound(int[] arr, int start, int end) {

		if (start == end)
			return 0;
		if ((end-start) % 2 == 0)
			return arr[(end-start)/2];
		else
			return (arr[(end-start)/2]+arr[((end-start)/2)-1])/2;
	}


}
