package dynamicProgramming;

public class StairPathCountWithJump {
	
	/* Given 'n' -> no of stairs 
	 * 'options' array -> corresponding each steps(from array stating 0) give no of max 
	 *                    jump can be taken at that step
	 * e.g. options[] = { 3, 3, 0, 2, 2, 3}  
	 *                    0  1  2  3  4  5  6   (n = no of stairs)
	 *        dpArr[] = { 8, 5, 0, 3, 2, 1, 1}  // initalize last by 1            
	 * dpArr represent no of ways to reach destination step (n) from that current position index(step) */
	public static int pathCount(int n, int[] options) {
		int[] dpArr = new int[n+1];
		for (int i = 0; i < n+1; i++)
			dpArr[i] = 0;
		dpArr[n] = 1; // when already at last step, no ways to reach last step = 1 i.e. don't move
		
		for (int i = n-1; i >= 0; i--) {
			if(options[i] > 0) {
				int j = i; int c = options[i];
				while(c!=0 && j<n) {
					dpArr[i] = dpArr[j+1] + dpArr[i];
					c--;
					j++;
				}
			}else
				dpArr[i] = 0;
		}
		return dpArr[0];
	}
	
	public static void main(String[] args) {
		int n = 6;
		int[] options = {3,3,0,2,2,3};
		System.out.println(pathCount(n, options));

	}

}
