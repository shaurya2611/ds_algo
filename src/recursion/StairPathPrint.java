package recursion;

public class StairPathPrint {

	// Given a person can take step of 1, 2 or max 3 steps. Find the no ways to reach destination
		// e.g. for 3 --> [111,12,21,3] possible ways
	
	//STAIRPATH function have 2^n space complexity as we were storing the data in Array list,
		 //Here EULER method of recursion to get the ans for each branch
		 public static void printStairPaths(int n, String ans){
			 if(n==0) {
				 System.out.println(ans);
			 return;
			 }
		 	else if(n<0)
				 return;
			 
			 printStairPaths(n-1, 1+ans);
			 printStairPaths(n-2, 2+ans);
			 printStairPaths(n-3, 3+ans);
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printStairPaths(5,"");

	}

}
