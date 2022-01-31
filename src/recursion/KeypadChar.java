package recursion;

import java.util.ArrayList;
import java.util.Iterator;

public class KeypadChar {
	// user will enter digits as per keypad, get all the possible strings formations from pressed keys
	static String[] codes = { ".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	
	public static ArrayList<String> getKPC(String str) { // f(970)
		//base case
		if(str.length()==0) {
			ArrayList<String> a = new ArrayList<>();
			a.add("");
			return a;
		}
		//Hypothesis
		char ch = str.charAt(0);//9
		String subStr = str.substring(1);//70
		ArrayList<String> recResult = getKPC(subStr); // {'t.','t;','u.','u;'} by recursion
		//induction 
		ArrayList<String> result = new ArrayList<>();
		String code = codes[ch-'0']; //'yz'
		for (int i = 0; i < code.length(); i++) {
			for(String item  : recResult)
				result.add(code.charAt(i)+item);
		}
		return result;
    }
	
	public static void main(String[] args) {
		ArrayList<String> ans = getKPC("");
		System.out.println(ans);

	}

}
