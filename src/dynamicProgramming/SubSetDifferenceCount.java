package dynamicProgramming;

public class SubSetDifferenceCount extends SubSetSumCount{

	// ------------------COUNT OF SUBSETS OF GIVEN DIFFERENCE---------------
	/*An array and a difference will be input --> finding the no of different subset having same difference
	  Make two sub array from array - a1 and a2 and finding there sum of elements as s1 and s2.
	  given --> s1 - s2 = d  , 
	  and   --> s1 + s2 = range
	  thus  --> s1 = (d + range)/2 {d a dn range are known, thus s1 and s2 can be finded out}
	  Problem reduced to "COUNT OF SUBSET SUM"  for S1 or S2 any one. 
	*/
	
	
	/* -------------------------------TARGET SUM--------------------------------
	 * Given an array insert'+' and '-' no between the elements such that result = given no
	 * This Question is same as SUB set difference count. By inserting + and - symbols two sub sets are
	 * formed such that final result is = to given no.
	 * */
	public static int subSetDiffCount(int[] arr, int size, int diff) {
		
		int range = 0;
		for (int i = 0; i < arr.length; i++)
			range+=arr[i];
		
		int subS1 = (diff + range)/2;
		
		// for a given array count the number of subsets possible for the given sum
		int count = subSetCount(arr, subS1,size);
			
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,3};
		int size = arr.length;
		int sum = 1;
		System.out.println(subSetDiffCount(arr, size, sum));

	}

}
