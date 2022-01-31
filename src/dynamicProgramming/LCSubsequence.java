
package dynamicProgramming;

public class LCSubsequence {
	
	// SUBSEQUENCE --> continuous or non continuous (in same order) 
	// SUBSTRING --> Continuous (in same order)
	
	public static int longestCommonSubsequence(String a, String b,int x,int y) {
		//base condition
		if(x==0|| y==0)
			return 0;
		
		if(a.charAt(x-1) == b.charAt(y-1))
			return 1 + longestCommonSubsequence(a, b, x-1, y-1);
		else
			return Math.max(longestCommonSubsequence(a, b, x-1, y) ,
					        longestCommonSubsequence(a, b, x, y-1));
	}
	
	public static int lcsdpArr(String a, String b,int x,int y) {
		int[][] dpArr = new int[x+1][y+1];
		
		// Array Initialization (base case)
		for (int i = 0; i < x+1; i++)
			dpArr[i][0] = 0;
		for (int i = 0; i < y+1; i++)
			dpArr[0][i] = 0;
		
		for (int i = 1; i < x+1; i++) {
			for (int j = 1; j < y+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
				else
					dpArr[i][j] = Math.max(dpArr[i-1][j],dpArr[i][j-1]);
			}	
		}
		return dpArr[x][y];
	}
	
	public static void main(String[] args) {
		String a = "abcdefgh";
		String b = "abchgde";
		int x = a.length(); int y = b.length();
		System.out.println(longestCommonSubsequence(a, b, x, y));
		System.out.println(lcsdpArr(a, b, x, y));
		

	}

}
