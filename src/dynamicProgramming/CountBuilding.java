package dynamicProgramming;

public class CountBuilding {

	/*  1. Given number n, represents the length of a road. The road has n plots on it's each side.
		2. The road is planned that there should not be consecutive buildings on either side of the road.
		3. the number of ways in which the buildings can be built on both side of roads.
		This ques is same as the ---Binary String Count-- after finding building one side square the result
		as for each position equal option available opposite side.
	 * */

	public static int BuildingCount(int n) {
		
		if(n==0)
			return 0;
		
		int oldZero = 1;
		int oldOne = 1;
		
		for (int i = 2; i < n+1; i++) {
			int newZero = oldOne ;
			int newOne = oldOne + oldZero;
			
			oldZero = newZero;
			oldOne = newOne;
		}
			
		return (oldOne+oldZero)*(oldOne+oldZero);
	}
	
	public static void main(String[] args) {
		System.out.println(BuildingCount(3));

		
	}

}
