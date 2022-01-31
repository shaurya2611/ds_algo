package dynamicProgramming;

public class LCSubstring {

	// SUBSEQUENCE --> continuous or non continuous (in same order) 
		// SUBSTRING --> Continuous (in same order)
		
	public static int longestCommonSubstring(String a, String b,int x,int y) {
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
					dpArr[i][j] = 0;
			}	
		}
		return dpArr[x][y];
	}
	
	
	
	public static void main(String[] args) {
		String a = "abcdefgh";
		String b = "abchgde";
		int x = a.length(); int y = b.length();
		System.out.println(longestCommonSubstring(a, b, x, y));

	}

}
