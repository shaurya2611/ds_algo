package recursion;

import java.util.ArrayList;

public class StairPath {

	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> paths = getStairPaths(n);
		System.out.println(paths);
		System.out.println("From print funtion ---");
//		printStairPaths(n, "");

	}
	
	// Given a person can take step of 1, 2 or max 3 steps. Find the no ways to reach destination
	// e.g. for 3 --> [111,12,21,3] possible ways
	 public static ArrayList<String> getStairPaths(int n) {
		 //base case
		 if(n==0) {
			 ArrayList<String> p = new ArrayList<>();
			 p.add("");
			 return p;
		 }else if(n<0) {
			 ArrayList<String> p = new ArrayList<>();
			 return p;
		 }
		 
	     //Hypothesis by considering all 3 situations
		 ArrayList<String> p1 = getStairPaths(n-1);
		 ArrayList<String> p2 = getStairPaths(n-2);
		 ArrayList<String> p3 = getStairPaths(n-3);
		 //Induction
		 ArrayList<String> paths = new ArrayList<>();
		 for(String item : p1)
			 paths.add(1+item);
		 for(String item : p2)
			 paths.add(2+item);
		 for(String item : p3)
			 paths.add(3+item);
			 
		 return paths;
	    }
	 
	 


}
