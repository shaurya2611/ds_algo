package hashing;

import java.util.HashMap;

/*
 * Given : Given a string s, find the length of the longest substring without repeating characters.
   			Input  : s = "abcabcdb"
			Output : 4
 
 * Solution 1 : Using 2 loops form all the continuous subarrays and find their length by applying condition.
 * 				Time - O(n^3) ,     Space - O(n)
 * 
 * Solution 2 : 
 * 				Time - O(n) , Space - O(n)
 * 
 * */

public class LongestSubstringWithoutRepeatingChar {
	
	public int lengthLongestSubstring(String s) {
		int maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		int n = s.length();
		
		while(right < n) {
			if(map.containsKey(s.charAt(right)))
				left = Math.max(map.get(s.charAt(right))+1,left);
			
			map.put(s.charAt(right),right);
			maxLen = Math.max(maxLen, right-left+1);
			right++;
		}
		return maxLen;
	}
	

}
