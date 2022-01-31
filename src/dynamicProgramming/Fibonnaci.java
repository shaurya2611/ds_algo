package dynamicProgramming;

public class Fibonnaci {

	public static int fibRecursive(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
		int no = fibRecursive(n-1) + fibRecursive(n-2);
		return no;
	}
	
	public static int fibDP(int n, int[] dpArr) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
		if(dpArr[n]!=-1)
			return dpArr[n];
		
		return dpArr[n] = fibRecursive(n-1) + fibRecursive(n-2);
	}
	
	
	public static void main(String[] args) {
		int n =10;
		System.out.println(fibRecursive(n));
		int[] dpArr = new int[n+1];
		for (int i = 0; i < dpArr.length ; i++) 
			dpArr[i] = -1;
		System.out.println(fibDP(n,dpArr));

	}

	
	
}
