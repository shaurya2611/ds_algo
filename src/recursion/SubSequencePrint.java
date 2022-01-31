
package recursion;

public class SubSequencePrint {

	
	/* Subsequence - in same order not necessary continuous - 2^n - subsequences for length 'n'
	//               each character has two option, either to participate or not
	//              e.g. - 'abc' --> ---, 
									 --c,
									 -b-,
								     -bc,
									 a--,
									 a-c,
									 ab-,
								      abc 
					(notice wrt 'a', in each string a has two option either yes or no-- similarly for all)*/ 
	
	
	// -----------------------PRINT ALL SUBSEQUENCES------------------------
		public static void printSS(String str, String ans) { // f("", "") , f("abc", "")
			// base condn
	        if(str.length()==0){
	            System.out.println(ans);
	            return;
	        }
	        
	        char ch = str.charAt(0);  //a
	        String substr = str.substring(1); //bc
	        printSS(substr, ans+ch); // OPTION 1 --> taking ch (a)
	        printSS(substr, ans+"_"); // OPTION 2 -->  not considering ch (" ")
	         
	    }
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSS("759", "");

	}

}
