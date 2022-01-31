package dynamicProgramming;

public class LRepeatingSubsequence {

	/* Given a staring finding the longest  repeating subsequence within that string
	 * e.g -> "AABEBDCD" --> repeating subseqs - {ABD*2 , AB*2, BD*2, AD...etc} -ABD longest repeating
	 * Solution - find the LCS for the given string with itself such that (i!=j) rest code same as of LCS
	 * */
	public static int lrs(String a, int x) {
		String b = a;
		int y = x;
		
		int[][] dpArr = new int[x+1][y+1];
		
		// Array Initialization (base case)
		for (int i = 0; i < x+1; i++)
			dpArr[i][0] = 0;
		for (int i = 0; i < y+1; i++)
			dpArr[0][i] = 0;
		
		for (int i = 1; i < x+1; i++) {
			for (int j = 1; j < y+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1) && i!=j)//  <------only difference in code HERE
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
				else
					dpArr[i][j] = Math.max(dpArr[i-1][j],dpArr[i][j-1]);
			}	
		}
		return dpArr[x][y];

	}
	public static void main(String[] args) {
		String a = "aabebcdd";
		int x = a.length();
		System.out.println(lrs(a, x));

	}

}
