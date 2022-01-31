 package dynamicProgramming;

public class SubSetDifferenceMin {

	/*
	 * Given an array find two subsets from it such that the sum of difference of
	 * both the subsets is minimum e.g. --> {2,5,8,3,11,4} -> {8,3,5} & {11,4,2}
	 * difference = 1 i.e. min
	 * 
	 * Sol- S1 -S2 = d (min) , S1 + S2 = sum array(range) Find the all the subset
	 * possible from 0-range and select subset with min d. Main aim is to get the
	 * last row of the matrix i.e. It will contains below scenario -- Array
	 * available will be = Size = n(full array) and corresponding columns[0-range]
	 * will represent Weather with full available array for particular column no
	 * SUBSETSUM is possible or not.
	 */
	public static int minSubSetDifference(int[] arr, int size) {
		int range = 0;
		for (int i = 0; i < arr.length; i++)
			range += arr[i];
		
		// Apply SUBSEUSUM logic to range starting from zero.
		boolean[][] dpArr = new boolean[size + 1][range + 1];

		for (int i = 0; i < size + 1; i++) { // i -> rows -> size , j -> columns -> range
			for (int j = 0; j < range + 1; j++) {
				if (i == 0)
					dpArr[i][j] = false;
				if (j == 0)
					dpArr[i][j] = true;
			}
		}
		
		for (int i = 1; i < size + 1; i++) { // i -> rows -> size , j -> columns -> range
			for (int j = 1; j < range + 1; j++) {
				if(arr[i-1] <= j)
					dpArr[i][j] = dpArr[i-1][j-arr[i-1]] || dpArr[i-1][j];
				else
					dpArr[i][j] = dpArr[i-1][j];
			}
		}
		

	    /*Main aim is to get the last row of the matrix i.e. It will contains below scenario --
	    Array available will be = Size = n(full array) and corresponding columns[0-range] will represent
	    Weather with full available array for  particular column no SUBSETSUM is possible or not.
	     */
	    int minDiff = range;
	    //range/2 bcz (s2-s1 = min subset sum) and (s1+s2=Range) hence -> [min subset sum = (Range - 2*s1)]   
	    for(int i=0;i<=range/2;i++) {
	        if (dpArr[size][i]==true){
	            minDiff = Math.min( minDiff , (range-(2*i)) );
	        }
	    }
	    return minDiff;
	}

	public static void main(String[] args) {
		int arr[] = {5,8,3,11,6};
		int size = arr.length;
		System.out.println(minSubSetDifference(arr, size));

	}

}
