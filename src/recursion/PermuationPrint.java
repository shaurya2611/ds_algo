package recursion;

public class PermuationPrint {
	
	/* Subsequence - in same order but not necessary continuous - (2^n) - subsequences for length 'n'
	 *					in subsequence not necessary all charters of given string used.
	//               each character has two option, either to participate or not
	//              e.g. - 'abc' --> ---, --c, -b-, -bc, a--, a-c, ab-, abc 
					(notice wrt 'a', in eacg string a has two option either yes or no-- similarly for all)*/ 
   	
	// Substring   -  in same order and continuous,     n(n+1)/2 - string for length 'n'
	//				in subsequence not necessary all charters of given string used.
	//			    e.g. - 'abc' --> a, ab, abc, b, bc, c
	
	
	/* Permutation - all the characters of given string used. -- (n!) - string of length 'n'
	 * 				order not important,should be continuous, length fixed
	 * 				e.g. - 'abc' --> abc, acb, bac, bca, cba, cab
	 */
	

	/* Function to print all the permutations of string (possible string rearrangement)
	 * 
	 * Solution - Iterate over all the characters. 
	 * 			  pick a character, store remaining in another string
	 * 			  pass remaining in fn and add picked character in ans
	 */
    public static void printPermutn(String str, String ans) 
    { 
  
        // If string is empty 
        if (str.length() == 0) { 
            System.out.print(ans + " "); 
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding ith character 
            String ros = str.substring(0, i) + str.substring(i + 1); 
  
            // Recurvise call 
            printPermutn(ros, ans + ch); 
        } 
    } 
	
	public static void main(String[] args) {
		String str = "abc";
		printPermutn(str,"");

	}

}
