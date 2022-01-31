package backTracking;

public class TargetSumSubsets {

	
	/* -----...............-BACKTRACKING ALGO------------------------
	 *  Step 1 − if current_position is goal, return success
		Step 2 − else,
		Step 3 − if current_position is an end point, return failed.
		Step 4 − else, if current_position is not end point, explore and repeat above steps.
	*/
	
	 public static void printTargetSumSubsets(int[] arr, int idx, int target, String set, int sumSet) {
	        if(sumSet==target) {
	        	System.out.println(set);
	        	return ;}
	        else if(idx==arr.length)
	        	return;
	        else {
	        	// element taken in subset
	        	Integer val = arr[idx];
	        	printTargetSumSubsets(arr, idx +1, target, set + val.toString(), sumSet+arr[idx]); 
	        	// element not taken in subset
	        	printTargetSumSubsets(arr, idx +1, target, set , sumSet); 
	        }
	    }

	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int target = 7;
		printTargetSumSubsets(arr, 0, target, "", 0);
	}

}
