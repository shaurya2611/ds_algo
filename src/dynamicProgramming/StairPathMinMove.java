package dynamicProgramming;

public class StairPathMinMove {

	
	/* Given 'n' -> no of stairs 
	 * 'options' array -> corresponding each steps(from array stating 0) give no of max 
	 *                    jump can be taken at that step
	 *                    
	 * e.g.   options[] = { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2}  
	 *                      0  1  2  3  4  5  6  7  8  9     (n = no of stairs = 10)
	 *                      
	 * Solution dpArr[] = { 4, 4, 3, 4, N, 3, 2, 2, 1, 1, 0}  // initialize DpArr with NULL 
	 * 						0  1  2  3  4  5  6  7  8  9  10         
	 * dpArr read as minimum no of ways to reach from current step to 10th stair 
	 * Standing on 10th step min step req = 0, 
	 * while on 9th step min step req to reach 10th = min(10th) available choice 2 + 1
	 * while on 8th step min(9th,10th) as available choice 2 + 1
	 * while on 6th step min (7th,8th,9th) as available choice 3 + 1
	 * similary on oth floor min step to reach 10th = 4 ans*/
	
	public static int pathCount(int n, int[] options) {
	
		Integer[] dpArr = new Integer[n+1]; // Integer by default initialize all element to NULL , int to zero
		//10th floor initialize
		dpArr[n] = 0;
			
		for (int i = n-1; i>=0; i--) {
			if(options[i] > 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <=options[i] && i+j<dpArr.length; j++) {
					if(dpArr[i+j]!=null)
						min = Math.min(min, dpArr[i+j]);
				}
				if(min!=Integer.MAX_VALUE)
					dpArr[i] = min+1;
				
			}
		}
		return dpArr[0];
	}
	
	
	public static void main(String[] args) {
		int n = 10;
		int[] options = { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2} ;//{ 1,1,1,4,9,8,1,1,10,1};
		System.out.println(pathCount(n, options));       //5

	}

}
