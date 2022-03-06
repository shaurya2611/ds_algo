package hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoElementSum {
	
	/*
    Given : Given an array of integers nums and an integer target, return indices of the two numbers such 
            that they add up to target.
            
    Solution 1 : Comparing each and every element with its right array elements to make up sum = target
                    i.e Two pointer --> forming all apir and check their sum
                  Time - O(n^2) ,   Space - O(1)
                  
    Solution 2 : Using hash map, take element find (target - element) in map if present return else
                  store that element with its index in hash table.
                  Time - O(n) ,     Space - O(n)
                  
   
   
   HASHMAP (key-value pair) --> 
   * to check key in map      :    map.containsKey(key)
   * to add key-value pair    :    map.put(key,value)
   * to get value for the key :	   map.get(key)
   
   HASHSET (only value) -->
   * to add value		      :    hashSet.add(element)
   * to check element in set  :    hashSet.contains(element) 
    
  */
  public int[] twoSum(int[] nums, int target) {
      
      // array to store both elements index
      int[] result = new int[2];
      
      // Hash map to store the element(KEY) and their index(VALUE)  (as key-value pair)
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      for(int i=0; i<nums.length; i++){
    	  // Considering current element as one part of pair finding second part in map
          if(map.containsKey(target-nums[i])){
              result[1] = i;
              result[0] = map.get(target - nums[i]);
              return result;
          }
          // If second part of pair not found in map, add it in map
          map.put(nums[i],i);
      }
      return result;
  }

}
