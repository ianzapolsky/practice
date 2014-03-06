// Maximum subarray problem from Chapter 4 in Introduction to Algorithms.
// Find the contiguous subarray of A whose values have the larges sum.
// by Ian Zapolsky (02/10/14)

public class MaxSubarray {

	public static void main(String[] args) {

		int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

		long start = System.nanoTime();
		System.out.println(findMaxSubBrute(A));
		long end = System.nanoTime();
		System.out.println("find max sub brute force took "+(end-start)+" ns.");

		start = System.nanoTime();
		System.out.println(findMaxSubDivAndConq(A, 0, A.length-1));
		end = System.nanoTime();
		System.out.println("find max sub divide-and-conquer took "+(end-start)+" ns.");

	}

	// brute force = O(n^2)
	public static int findMaxSubBrute(int[] a) {

		// sanity checks for 0 and 1-element arrays
		if (a.length == 0) return 0;
		else if (a.length == 1) return a[0];

		int maxSum = Integer.MIN_VALUE;
		int maxStart = 0;
		int maxEnd = 0;

		// check all possible options
		for (int i = 0; i < a.length-1; i++) {
			int tmpSum = a[i];
			for (int j = i+1; j < a.length; j++) {
				tmpSum += a[j];
				// if the sum of the elements of the current contiguous subarray
				// is greater than maxSum, set maxSum to the current sum, and
				// update the start and end indices of the max sub array
				if (tmpSum > maxSum) {
					maxSum = tmpSum;
					maxStart = i;
					maxEnd = j;
				}
			}
		}

		// print the indices, return the number
		//System.out.println("our maximum subarray was found between "+maxStart+" and "+maxEnd+" (on a 0-based index array)");
		return maxSum;

		// or perhaps we should return this information as an array of integers
		// int[] result = {maxSum, maxStart, maxEnd};
		// return result;
	}

	// divide-and-conquer
	public static int findMaxSubDivAndConq(int[] a, int start, int end) {

		// sanity checks for 0 and 1-element arrays
		if (start == end) return 0;

		int mid = ((start+end)/2);
		int leftSum = findMaxSubDivAndConq(a, start, mid);
		int rightSum = findMaxSubDivAndConq(a, mid+1, end);
		int crossSum = findMaxCrossSub(a, start, mid, end);

		if (leftSum >= rightSum && leftSum >= crossSum)
			return leftSum;
		else if (rightSum >= leftSum && rightSum >= crossSum)
			return rightSum;
		else return crossSum;
	}

	public static int findMaxCrossSub(int[] a, int start, int mid, int end) {
		int leftSum = Integer.MIN_VALUE;
		int maxStart = 0;
		int tmpSum = 0;
		for (int i = mid; i >= start; i--) {
			tmpSum += a[i];
			if (tmpSum > leftSum) {
				leftSum = tmpSum;
				maxStart = i;
			} 
		}

		int rightSum = Integer.MIN_VALUE;
		int maxEnd = 0;
		tmpSum = 0;
		for (int i = mid+1; i <= end; i++) {
			tmpSum += a[i];
			if (tmpSum > rightSum) {
				rightSum = tmpSum;
				maxEnd = i;
			}
		}

		//System.out.println("our maximum subarray was found between "+maxStart+" and "+maxEnd+" (on a 0-based index array)");
		return (leftSum+rightSum);
	}

}
