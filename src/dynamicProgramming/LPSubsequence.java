package dynamicProgramming;

public class LPSubsequence extends LCSubsequence{

	// --------LONGEST PALINDROMIC SUBSEQUENCE--------
	/* Given a input string we have to find the longest PALINDOMIC substring
	   Solution - To apply LCS - LCS takes two input string and return an int.
	   Here we have only one input string, SECOND STRING can be taken as reverse of first one, and appky LCS
	 */
	public static int lps(String a, int size) {
		String b = "";
		for (int i = size-1; i >= 0; i--) 
			b = b + a.charAt(i); // reversed string a
		
		int subSequence = longestCommonSubsequence(a, b,size,size);
		
		return subSequence;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
