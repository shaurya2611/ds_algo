package dynamicProgramming;

public class DecodeStringWays {
	
	/* Given a numeric string - find all the possible character strings can be formed from it
	 * An element of dpArr means --> No of strings possible at that particular index length
	 * Solution - By counting and filling DP approach*/
	public static int decodeWays(String a) {
		if(a.length()==0)
			return 0;
		
		int[] dpArr = new int[a.length()];
		
		dpArr[0] = 1;
		
		for (int i = 1; i < dpArr.length; i++) {
			if(a.charAt(i)=='0' && a.charAt(i-1)=='0')
				dpArr[i] = 0;
			else if(a.charAt(i-1)=='0' && a.charAt(i)!='0')
				dpArr[i] = dpArr[i-1];
			else if(a.charAt(i-1)!='0' && a.charAt(i)=='0') {
				if(a.charAt(i-1)=='1' || a.charAt(i-1)=='2')
					dpArr[i] = (i>=2) ? dpArr[i-2] : 1;
				else
					dpArr[i] = 0;
				}
			else {
				if(Integer.parseInt(a.substring(i-1, i+1))<=26)
					dpArr[i] = dpArr[i-1] + (i>=2?dpArr[i-2]:1);
				else
					dpArr[i] = dpArr[i-1];
			}
		}
		return dpArr[a.length() -1];
	}
	
	
	public static void main(String[] args) {
		System.out.println(decodeWays("21123"));

	}

}
