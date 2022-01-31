package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourElementSum {
	
	/*
	 * Given :  Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
	 * 			such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
	 * 			Input: nums = [1,0,-1,1,1,0,-2,2,2], target = 0
				Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
				
	   Solution 1: Sorting the array. Fixing two pointers starting from 1st and 2nd element, and finding rest 2 element
	   				No duplicates iwll be there as 
	   				Time - O(nlogn + n^3) , Space - O(1)
	   		
				
	 * */
	 public ArrayList<List<Integer>> find4Numbers(int A[], int n, int X)
	    {
		 	ArrayList<List<Integer>> returnList = new ArrayList<List<Integer>>();
		 	if(n==0)
		 		return returnList;
		 	
	        // function for quick sort
	        Arrays.sort(A);   // O(nlogn)
	 
	        /* Now fix the first 2 elements one by one and find the other two elements -- O(n*n*n) */
	        for (int i = 0; i < n; i++)
	        {
	            for (int j = i + 1; j < n ; j++)
	            {
	            	int target_2 = X - A[i] - A[j];
	            	
	                // Initialize two variables as indexes of the first and last elements in the remaining elements
	                int front = j + 1;
	                int back = n - 1;
	                // To find the remaining two elements, move the index variables (l & r) toward each other.
	                while (front < back)
	                {
	                	int two_sum = A[front] + A[back];
	                
	                	if (two_sum < target_2) front++;
	                	else if (two_sum > target_2) back--;
	                	else {
	                		List<Integer> quad = new ArrayList<Integer>();
	                		quad.add(A[i]);
	                		quad.add(A[j]);
	                		quad.add(A[front]);
	                		quad.add(A[back]);
	                		returnList.add(quad);
	                				
	                		// Processing duplicates of Number 3
	                		while(front < back && A[front]==quad.get(2))++front;
	                		
	                		// Processing duplicates of Number 3
	                		while(front < back && A[back]==quad.get(3))--back;
	                	}
	                }
	             // Processing duplicates of Number 2
            		while(j+1 < n && A[j+1]==A[j])++j;
	            } 
	         // Processing duplicates of Number 1
        		while(i+1 < n && A[i+1]==A[i])++i;
	        }
			return returnList; 
	    }
}
