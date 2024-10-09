package array.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayZeroSum {

/*
Given: an array containing both positive and negative integers, we have to find the length of
        the longest subarray with the sum of all elements equal to zero.
Example: {9, -3, 3, -1, 6, -5} , Output -> 5 i.e. {-3, 3, -1, 6, 5}
*/



    // Form all possible sub arrays and their sum
    // Time O(n^2) , Space O(1)
    public static int bruteForce(int[] arr){
        int zeroSumSubArray = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i ; j < arr.length; j++) {
                sum+=arr[j];
                if(sum==0){
                    zeroSumSubArray = Math.max(zeroSumSubArray, j-i+1);
                }
            }
        }

        return zeroSumSubArray;
    }


    /* Using prefix sum, store prefix sum and index of that prefix sum in map and  if we observe that 2 elements
         have the same prefix sum, we can conclude that the 2nd part of this subarray sums to zero
      Time O(n) , Space O(n) */
    public static int optimalApproach(int[] arr){
        int zeroSumSubArray = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum+=arr[i];
            if (map.containsKey(prefixSum)){
                int subArrayWithZeroSum = i - map.get(prefixSum) ;
                zeroSumSubArray  = Math.max(zeroSumSubArray, subArrayWithZeroSum);
            }else {
                map.put(prefixSum,i);
            }
        }
        return zeroSumSubArray;
    }


    public static void main(String[] args){
        int[] arr = {1,-1 ,9, 2, -3, 3, -1, 6, -5,-2};
        int ans = LargestSubArrayZeroSum.optimalApproach(arr);
        String s = "";
    }
}
