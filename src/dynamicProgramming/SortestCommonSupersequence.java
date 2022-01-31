package dynamicProgramming;

public class SortestCommonSupersequence extends LCSubsequence{

	// 5.  SORTEST COMMON SUPERSEQUENCE
	/* Given two strings  form a single string such that it contains all the elements of both the strings in sequence
	   Form a such supersrquence abd return the legth of such shortest superseq. string
	   Solution -  Find the LCS and sub it from both*/
	public static int sortestCommonSuper(String a, String b, int x, int y) {
		int lcs = longestCommonSubsequence(a, b, x, y);
		return lcs + (x-lcs) + (y-lcs);
	}
	
	public static void main(String[] args) {
		
		String a =  "AGGTAB"; String b = "GXTXAYB";
		int x = a.length() ; int y = b.length();
		System.out.println(sortestCommonSuper(a, b, x, y));

	}

}
