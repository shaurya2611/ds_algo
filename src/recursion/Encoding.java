package recursion;

public class Encoding {
	
	public static void encodingStrings(String str, String ans) { // (1234,"")
		
		 // If string is empty 
        if (str.length() == 0) { 
            System.out.println(ans); 
            return; 
        } 
        // if string is of length = 1
        else if(str.length()==1) {
        	char ch = str.charAt(0);
        	if(ch == '0')
        		return;
        	else { // convert digit string into integer
        		int chInt = ch-'0';
        		// finding character corresponding that no in ABCD___series
        		char code = (char) ('a' + chInt -1);
        		System.out.println(ans+code);	
        	}
        }
		// if string length > 1
        else {
        	// considering 1 character only
        	  char ch1 = str.charAt(0);      // 1st character
        	  String ques = str.substring(1); // rest string
        	  if(ch1 == '0')
        		  return;
        	  else { 
        		  int chInt = ch1-'0';
        		  char code =  (char) ('a' + chInt -1); // adding to answer
        		  encodingStrings(ques,ans+code);
        		
        	// considering 1&2 character at once
        		String ch12 = str.substring(0, 2);
        		String ques2 = str.substring(2);
        		int chInt12 = Integer.parseInt(ch12);
        		if(chInt12<=26) {
        			char code2 = (char) ('a' + chInt12 -1);
        			encodingStrings(ques2,ans+code2);
        		}
        	
        	}
        	
        }
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encodingStrings("123","");

	}

}
