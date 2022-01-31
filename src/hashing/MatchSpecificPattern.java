package hashing;

import java.util.ArrayList;
import java.util.HashMap;

/* Given :  Dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character 
 * 			in the dictionary. Find all such words in the dictionary that match the given pattern. 
			dict[] = {abb,abc,xyz,xyy}
			pattern  = foo
			Output: abb xyy
 * 
 * Solution 1 : make a hash of the word and pattern and compare if they are equal or not. Assign different integers 
 * 				to the distinct characters of the word and make a string of integers (hash of the word) according to 
 * 				the occurrence of a particular character in that word and then compare it with the hash of the pattern.
 * 		       Time Complexity: O(N*K) ,   Auxiliary Space: O(N). 
 * 
 * */
public class MatchSpecificPattern {
	
	public void patterMatch(ArrayList<String> dict, String pattern) {
		// len is length of the pattern
        int len = pattern.length();
        // encode the pattern string
        String hash = hashString(pattern);
 
        for (String word : dict) {
            if (word.length() == len
                && hashString(word).equals(hash))
                System.out.print(word + " ");
        }
	}

	public String hashString(String s) {
		String hashed = "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int c = 0;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
            // If the character is occurring for the first
            // time, assign next unique number to that char
            if (!map.containsKey(ch))
                map.put(ch, c++);
 
            // append the number associated with current
            // character into the output string
            hashed += map.get(ch);
		}
		return hashed;
	}
	
	
}
