package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsequitiveSequence {
	
	/*
	 * Given : unsorted array of integers nums, return the length of the longest consecutive elements sequence.
	 * 			nums = {10,5,9,1,11,8,6,15,3,12,2} --> Ans: {8  9  10  11  12}

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
	
	 public void longestConsecutive(int[] arr) {

		 HashMap<Integer, Boolean> charTrack = new HashMap<>();
		 //storing all elements in hashmap with 'true' as default key
		 for(int i: arr){
			 charTrack.put(i,true);
		 }
		// after this loop only the starting element of all the subsequences will be marked true, rest false
		 for (int i: arr){
			 if(charTrack.containsKey(i-1))
				 charTrack.put(i,false);
		 }
		 // if the element is true then start printing its subsequences if present in hashmap
		 for(int i: charTrack.keySet()){
			 if(charTrack.get(i)==true){
				 boolean flag =true;
				 int no = i;
				 while(flag){
					 System.out.print(no+"  ");
					 if (charTrack.get(++no)==null) flag =false;
				 }
				 System.out.println();
			 }
		 }
	    }

}
