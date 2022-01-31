package dynamicProgramming;

public class EqualSumPartition extends SubSetSum{

	/*Partition array in two subset such that sum of both partition are equal 
	 e.g. - {1,5,11,5} --> True as (1,5,5,) and (11) 
	 
	 Sol -* If sum of all array element is odd return FALSE
	      * If even Then find sum/2 then find if this SUBSETSUM possible, since 2 equal 
	        Portion has to be made one subset must have to be sum of given array/2 
	 */
	public static boolean equalSumPartition(int[] arr, int size) {
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum+=arr[i];
		
		if(sum%2!=0)
			return false;
		else
			return subSetDP(arr, sum/2, size);
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2,5,11,5};
		int size = arr.length;
		System.out.println(equalSumPartition(arr, size));

	}

}
