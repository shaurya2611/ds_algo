package hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequitiveSequence {
	
	/*
	 * Given : unsorted array of integers nums, return the length of the longest consecutive elements sequence.
	 * 			nums = [100,4,101,102,1,3,2] --> Ans: 4

	 * Solution 1 : Sort array, and by iterating for each element and taking counter if consecutive
	 * 				Time- O(nlogn + n) ~ nlogn, Space - O(1)
	 * 
	 * Solition 2 : Iterate over array and store all elements in an Hash set
	 * 				(Aim to find smallest element for each subset of consecutive element & start count from that smallest element)
	 * 				Take element and check wether (element-1) exits in HASHSET-- 
	 * 				* If exist     --> do nothing, move to next element
	 * 				* If not exist --> make increase element by 1 (element + 1), and check does that exist in set.
	 * 								   If (element+1) exist in set make count++, again check for (element+2) and soo on
	 * 								   till element don't exist in set. The count will show the length of consecutive elements.
	 * 				Repeat above process till last element and find the max length
	 * 				Time- O(n + n + n) ~ n, Space - O(n)
	 * */
	
	 public int longestConsecutive(int[] nums) {
	        int maxConsElements = 0;
	        
	        //Putting all Array element in HASHSET(no repeated element)
	        Set<Integer> hashSet = new HashSet<Integer>();
	        for(int element : nums) {
	        	hashSet.add(element);}
	        
	        for (int i = 0; i < nums.length; i++) {
				if(!hashSet.contains(nums[i]-1)) {
					int currentConsElement = 0;
					int element = nums[i];
					
					while(hashSet.contains(element)) {
						currentConsElement++;
						element++;
					}
					maxConsElements = Math.max(maxConsElements, currentConsElement);
				}
			}
	        
	        return maxConsElements;
	    }

}
