package dynamicProgramming;

public class LCSubsequencePrint {

	public static void LCSPrint(String a, String b, int x, int y) {
		int[][] dpArr = new int[x+1][y+1];
		// Array Initialization (base case)
		for (int i = 0; i < x+1; i++)
			dpArr[i][0] = 0;
		for (int i = 0; i < y+1; i++)
			dpArr[0][i] = 0;
		
		for (int i = 1; i < x+1; i++) {
			for (int j = 1; j < y+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
				else
					dpArr[i][j] = Math.max(dpArr[i-1][j],dpArr[i][j-1]);
			}	
		}
		
		int t=0  ;      
		for (int i = 1; i < x+1; i++) {
			for (int j = t; j <y; j++) {	   
				if(dpArr[i][j]!=dpArr[i][j+1]){			
					System.out.print(b.charAt(j));
					i++;
					t=j+1;
				}
			}
		}		
	}
	public static void main(String[] args) {
		String a = "abcdefgnh";
		String b = "xdfdjkh";
		int x = a.length(); int y = b.length();
		LCSPrint(a, b, x, y);

	}

}
