package dynamicProgramming;

public class CountBinaryStrings {

	/* Given SIZE of string to make from 0's and 1's only with - consecutive no two 0's not allowed
	 * Solution - e.g. for size = 5 , Make a 2D array -
	 * 			   i-> 0	1		2				3	           4								   5		
	 * 			0 -->  0   (0) 1   (10)    1    (010,110)     2    (1010,0110,1110)			   3       5
	 * 			1 -->  0   (1) 1   (01,11) 2    (101,011,111) 3    (0101,1101,1011,01111,1111) 5       8  = 13 ans
	 * 
	 * An element of Dparr -> count of ith length string ending with 0
	 * 					      count of ith length string ending with 1
	 * */
	
	public static int countStringDP(int size) {
		int[][] dpArr = new int[2][size+1]; // all initialized to 0 by default
		
		dpArr[0][1] = 1;
		dpArr[1][1] = 1;
		
		for (int i = 2; i < size+1; i++) {
			dpArr[0][i] = dpArr[1][i-1];
			dpArr[1][i] = dpArr[0][i-1] + dpArr[1][i-1];
		}
		
		return dpArr[0][size]+dpArr[1][size];	
	}
	
	/* Problem with above code - using memory,
	 * same can be solved with variable use only no use of memory*/
	public static int countStringVar(int size) {
		if(size==0)
			return 0;
		
		int oldZero = 1;
		int oldOne = 1;
		
		for (int i = 2; i < size+1; i++) {
			int newZero = oldOne ;
			int newOne = oldOne + oldZero;
			
			oldZero = newZero;
			oldOne = newOne;
		}
			
		return oldOne+oldZero;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countStringDP(10));
		System.out.println(countStringVar(10));
		
	}

}
