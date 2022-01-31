package recursion;

import java.util.ArrayList;

public class SubSequence {

	/* Subsequence - in same order but not necessary continuous - (2^n) - subsequences for length 'n'
	 *					in subsequence not necessary all charters of given string used.
	//               each character has two option, either to participate or not
	//              e.g. - 'abc' --> ---, 
									 --c,
									 -b-,
								     -bc,
									 a--,
									 a-c,
									 ab-,
									 
								     abc 
					(notice wrt 'a', in eacg string a has two option either yes or no-- similarly for all)*/ 
   	
	// Substring(Subarray)   - characters are in same order and continuous,     n(n+1)/2 - string for length 'n'
	//				in subsequence not necessary all charters of given string used.
	//			    e.g. - 'abc' --> a, ab, abc, b, bc, c
	
	
	/* Permutation - all the characters of given string used. -- (n!) - string of length 'n'
	 * 				order not important
	 * 				e.g. - 'abc' --> abc, acb, bac, bca, cba, cab
	 */
	
	
	
	/*----------------STORE SUBSEQUENCES IN ARRAY LIST---------
	 * Solution - Since subsequence all the character has two option either to come or not to come
	 * 			  thus taking same hypothesis and adding result*/
	
	public static ArrayList < String > gss(String str) {
        //basecase
        if (str.length() == 0) {
            ArrayList < String > baseCasertn = new ArrayList < > ();
            baseCasertn.add("");
            return baseCasertn;
        }
        //Hypothesis -- such that character at starting will have two choices
        char ch = str.charAt(0);
        str = str.substring(1);// from 1 to end
        ArrayList < String > rres = gss(str);

        //Induction
        ArrayList < String > fres = new ArrayList < > ();
        for (String x: rres)
            fres.add("" + x); // choice one --> not to participate
        for (String x: rres)
            fres.add(ch + x); //  choice two --> to participate
        return fres;

    }

	
	

	
	
	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<String>();
		arr = gss("abc");

	}

}
