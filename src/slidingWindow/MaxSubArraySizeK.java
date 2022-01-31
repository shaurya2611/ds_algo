package slidingWindow;

public class MaxSubArraySizeK {
	
	/* Given an array, find sub array of given window size 'K' such that that subarray have max sum among all possible subarray
	 * Subarray -  continuous element from array of length */
	public static int maxSubarraySizeK(int[] arr, int k) {
		int sum = 0;
		int maxSum = 0;
		int windowStart = 0;
		int windowEnd = 0;
		
		while(windowEnd < arr.length) {
			if(windowEnd < k) {
				sum+=arr[windowEnd];
				windowEnd++;
				maxSum = sum;
				}
			else {
				sum = sum - arr[windowStart]  +arr[windowEnd];
				maxSum = Math.max(sum, maxSum);
				windowEnd++;
				windowStart++;
			}
		}
			
		return maxSum;
	}
	

	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4; 
        System.out.println(maxSubarraySizeK(arr, k));
	}

}
