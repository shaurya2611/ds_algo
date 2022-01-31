package array;


//SUBARRAY - sub-array are always continuous set of elements from the array

/*
 * Given :  Find contiguous subarray(atleast one element) having largest sum. Only sum has to be returned not sub array
 * 
 * Solution 1:  Finding all the continuous subarray, then find the subarray with max sum
 * 				Use tewo foor loop to form all sub array as( for i(0-last element and for j(i-last element))
 * 				and one more loop to find sum of that particular array.
 * 				Time - O(n^3) ,     Space - O(n)
 * 
 * 				Can be furthus optimized to O(n^2) by avoiding 3rd for loop and perform addition in second loop itself
 * 
 * 
 * Solution 2: Kadane's Algo : Carry subarray sum, as long as it positive sum
 * 			   Time - O(n), Space - O(1)
 * */

public class MaxSumSubarray {
	
	 public int maxSubArray(int[] nums) {
	
		 int sum = 0;
		 int max = nums[0];
		 
		 for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];	
			max = Math.max(max, sum);
            // sum < 0 no need to carry,  it forward as it won't increase the sum
			// Carry subarray sum, as long as it positive sum -- KADANAYS ALGO
             if(sum<0) 
				sum=0;
		}
		 return max;
	    }
	
	

}
