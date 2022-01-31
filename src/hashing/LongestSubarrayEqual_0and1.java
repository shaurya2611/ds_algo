package hashing;

import java.util.HashMap;

public class LongestSubarrayEqual_0and1 { // same as LargestSubArrayZeroSum
	
  /*
    
    Solution 1: Take 2 for loop and form all the possible subarray and for each sub array
                check no of 1's and 0's
                Time - O(n^2) , Space - O(1)
                
    Solution 2: If we get same SUM at two different interval then the no element between them must be zero, 
    			as 0 taken as -1 and 1 as 1,
                Using hashmap keep track of the SUM and respective index they occured.
                Time -O(n), Space - o(n)
    
    */
    
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0)
                sum = sum + -1;
             else
                sum = sum +1;
             
            if(sum==0)
                max = i+1;
            else{
	            if(map.containsKey(sum))
	                 max = Math.max(max,i -map.get(sum));
	            else
	                map.put(sum,i);
            }
                
        }
        return max;
    }

}
