package hashing;

import java.util.HashMap;

/* Subarray : contiguous part of an array. This means all the elements of the subarray appear
				  in the same order as in the original array and are next to each other.
		No of subarray = n(n+1)/2
		Subarray of [1, 2, 3] = [1], [1,2], [1,2,3], [2], [2,3], [3]

	   Subset : A subset is any combination of elements from an array, regardless of their order and contiguity.
	   			This includes the empty set and the set itself.
		no of subsequences = 2^n
		Subset of [1,2,3] = [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
	*/

public class LargestSubArraySumZero {  //same as LongestSubarrayEqual_0and1
/*
 * Given 	 : An array and find the largest sub array with sum zero
				A[] = {15,-2,2,-8,1,7,10,23}    Output: 5
				Explanation: The largest subarray with  sum 0 will be -2 2 -8 1 7.
 
 
 * Solution 1: Form all the sub array using two lops amd in third for loop check formed subarray sum 
			 * Use two for loop to form all sub array as( for i(0-last element and for j(i-last element))
			 * 				and one more loop to find sum of that particular array.
			 * 				Time - O(n^3) ,     Space - O(n) 
			 * 
			 * Can be furthus optimized to O(n^2) by avoiding 3rd for loop and perform addition in second loop itself
			 
 * Solution 2: Algo : Let 10 element sum = S, and if part of it (1-4)element sum = S then reamining (5-10) element sum 
 * 					  will be zero, thus length subarray sum zero = 6
 * 				Sum-index pair will be stored in a hash-map.
 * 				if the same value appears twice in the array, it will be guaranteed 
 *  			that the particular array will be a zero-sum sub-array. 
 * 				Time - O(n) ,     Space - O(n)
 * 				(considering insertion and retival is o(1) in hashmap else O(nlogn))
 * 
 * */
public int SubarraySumZero(int[] arr) {
	int maxLen = 0;
	int sum = 0;
	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	
	for (int i = 0; i < arr.length; i++) {
		sum = sum + arr[i];
		if(sum==0)
			maxLen = i+1;
		else {
			// Sum-index pair stored in a hash-map.
			if(hashMap.containsKey(sum))
				maxLen = Math.max(maxLen, i - hashMap.get(sum));
			else
				hashMap.put(sum, i);
		}
	}
	
	return maxLen;
}
	
}
