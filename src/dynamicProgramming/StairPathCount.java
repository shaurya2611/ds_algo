package dynamicProgramming;

public class StairPathCount {
	
	// Find no of ways to reach the bottom, 1,2 or max 3 steps can be taken at a time
    public static int stairCount(int n) { // n = no of stairs
    	//base case
    	if(n<0)
    		return 0;
    	
    	if(n==0)
    		return 1;
    	//Hypothesis
    	int w1 = stairCount(n-1); // no of ways when 1 step taken 
    	int w2 = stairCount(n-2); // no of ways when 2 step taken  
    	int w3 = stairCount(n-3); // no of ways when 3 step taken 
    	// induction
    	int w = w1 + w2 + w3 ; // total ways
    	   	
    	return w;
    }
    
    public static int stairCountDP(int n, int[] dpArr) {
    	if(n<0)
    		return 0;
    	
    	if(n==0)// no of way when already on last stair
    		return 1;
    		
    	if(dpArr[n]!=-1)
    		return dpArr[n];
    	
    	//Hypothesis
    	int w1 = stairCount(n-1); //Starting with 1 step
    	int w2 = stairCount(n-2); //Starting with 2 step
    	int w3 = stairCount(n-3); //starting with 3 step
    	// induction
    	int w = w1 + w2 + w3 ; // total ways
    	
    	dpArr[n] = w;
    	return dpArr[n];// return w;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
