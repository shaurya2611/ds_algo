package recursion;

public class SubStringPrint {
	
	/* Subsequence - in same order but not necessary continuous - (2^n) - subsequences for length 'n'
	 *					in subsequence not necessary all charters of given string used.
	//               each character has two option, either to participate or not
	//              e.g. - 'abc' --> ---, --c, -b-, -bc, a--, a-c, ab-, abc 
					(notice wrt 'a', in eacg string a has two option either yes or no-- similarly for all)*/ 
   	
	// Substring   - characters are in same order and continuous,     n(n+1)/2 - string for length 'n'
	//				in subsequence not necessary all charters of given string used.
	//			    e.g. - 'abc' --> a, ab, abc, b, bc, c
	
	
	/* Permutation - all the characters of given string used. -- (n!) - string of length 'n'
	 * 				order not important
	 * 				e.g. - 'abc' --> abc, acb, bac, bca, cba, cab
	 */
	
	// find its recursive approach
	public static void SubString(String str, int n)
    {
       for (int i = 0; i < n; i++) 
           for (int j = i+1; j <= n; j++)
                System.out.println(str.substring(i, j));
    }
 
	    
	    
	    public static void main(String[] args) {
	    	SubString("hello",5);
	    }

}
