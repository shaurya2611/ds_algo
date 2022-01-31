package dynamicProgramming;

public class InsertionDeletionCount extends LCSubsequence {

	
	// 6.  MIN NUMBER OF INSERTION AND DELETION (to convert Sting A to string B)
	/* Find the LCS between 2 strigns then --
	   Len String A - LCS = No of deletion req. 
	   Len String B - LCS = No of insertion req. */
	public static void minInsertDelete(String a, String b, int x, int y){
	   
	   int lcs = longestCommonSubsequence(a, b, x, y);
	   System.out.println((x-lcs)+(y-lcs));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
