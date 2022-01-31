package dynamicProgramming;

public class SubSetSum {

	/*For a given array - to find if any subset present for which subset sum == given number
	  e.g.-> 2,3,7,8,10, sum=14 --> Ans- False {no such subset}
	                     sum=11 --> Ans- True  {3,8}
	* Same as 0_1KNAPSACK as each item can be taken once and element has 2 CHOICES.
	* to be selected and added to make 'sum' or get rejected 
	*/
	public static boolean subSetSum(int arr[], int sum, int size) {		
		// Base Case
		if(sum==0)
			return true;
		if(size==0 )
			return false;
				
		// Initial Check --> If element is greater than sum, then ignore it
        if (arr[size - 1] > sum)
            return subSetSum(arr, sum, size-1);
 
        /* Else apply 2 available choices on element
           (a) including the element      (b) excluding the element */
        return subSetSum(arr, sum, size-1)  || subSetSum(arr, sum - arr[size - 1],size-1);
	
	}
	
	
	
	// Same problem with top down approach
	public static boolean subSetDP(int[] arr, int sum, int size) {
		//array declare with variable parameters
		boolean[][] dpArr = new boolean[size+1][sum+1];
		
		//Initialize base condition by drawing table
		for(int i=0; i<sum+1; i++)
			dpArr[0][i]=false;
		for(int i=0; i<size+1; i++)
			dpArr[i][0]=true;
		
		for (int i = 1; i < size+1; i++) { //i-> size , j-> sum
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <=j) 
					dpArr[i][j] = dpArr[i-1][j-arr[i-1]] || dpArr[i-1][j];
				else
					dpArr[i][j] = dpArr[i-1][j];
			}
		}
				
		return dpArr[size][sum];
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int sum = 7;
		int size = arr.length; //last index send to function
		System.out.println(subSetSum(arr, sum, size));
		System.out.println(subSetDP(arr, sum, size));
	}

}
