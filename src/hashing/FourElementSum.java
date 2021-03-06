package hashing;

import java.util.*;

public class FourElementSum {
	
	/*
	 * Given :  Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
	 * 			such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
	 * 			Input: nums = [1,0,-1,1,1,0,-2,2,2], target = 0
				Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

	  Solution 1: Sort the array +  use three pointer i,j & k  + Binary search search on (k-lenght arr)
				Time - O(nlogn + n^3logn) , Space - O(1)
				here  nlog --> bcz of sorting , n^3 --> bcz of 3 for loops 3pointer taken and logn --> for binary search
				space O(1) --> although space taken to return and not taken in complexity
	* * */
	 public static void find4sumBrutforce(int[] arr, int sum){
		 Arrays.sort(arr);
		 HashSet<String> solution = new HashSet<>();
		 for (int i=0; i<arr.length-3;i++){
			 for (int j=i+1; j<arr.length-2;j++){
				 for (int k=j+1;k<arr.length-1; k++){
					 int sum3Numbers = arr[i] + arr[j] + arr[k];
					 int leftSum = sum - sum3Numbers;
					 int indx = Arrays.binarySearch(arr,k+1,arr.length,leftSum);
					 if(indx>=0){
						 solution.add(arr[i]+" "+arr[j]+' '+arr[k]+' '+arr[indx]);
					 }
				 }
			 }
		 }
		 System.out.println(solution);
	 }


	  /* Solution 2: Sorting the array. Fixing two pointers starting from 1st and 2nd element, and finding rest 2 element
	   				No duplicates will be there as
	   				Time - O(nlogn + n^3) , Space - O(1)
	   				here  nlog --> bcz of sorting , n^3 --> bcz of 2 for loops 2pointer taken and another n for the while loop
	   				space O(1) --> although space taken to return and not taken in complexity
	   				*/
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


	/* Solution 3: Using Hasing -- store two sum paor in hash map  and Again using for loops form 2 sum and search in map for complete sum
	* 				Time - O(n^2 + n^2), Space - O(n^2)
	* */
	static class pair{
		int i;
		int j;
		public pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

	public static void fourSumUsingHashing(int[] arr, int sum) {
		HashMap<Integer, pair> twoSum = new HashMap<Integer, pair>();
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				twoSum.put(arr[i] + arr[j], new pair(i,j));
			}
		}
		for (int k = 0; k < arr.length-1; k++) {
			for (int l = k + 1; l < arr.length; l++) {
				int leftSum = sum - arr[k] + arr[l];
				if (twoSum.containsKey(leftSum)) {
					//check for duplciate index, all 4 index should be different
					pair p = twoSum.get(leftSum);
					if(p.i!=k && p.i!=l && p.j!=k && p.j!=l)
						System.out.println(p.i + " " + arr[p.j] + " " + arr[k] + " " + arr[l]);
				}
			}
		}
	}

public static  void main(String[] args){
		 int[] arr = {10, 20, 30, 40, 1, 2};
		find4sumBrutforce(arr,0);
	System.out.println("-------------------------");
	fourSumUsingHashing(arr,91);
}
}
