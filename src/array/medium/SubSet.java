package array.medium;

public class SubSet {
	/* Subarray : contiguous part of an array. This means all the elements of the subarray appear
				  in the same order as in the original array and are next to each other.
		No of subarray = n(n+1)/2
		Subarray of [1, 2, 3] = [1], [1,2], [1,2,3], [2], [2,3], [3]

	   Subset : A subset is any combination of elements from an array, regardless of their order and contiguity.
	   			This includes the empty set and the set itself.
		no of subsequences = 2^n
		Subset of [1,2,3] = [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
	*/
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		int limit = (int) Math.pow(2, arr.length);
		String bin="";
		
		// finding the binary conversion for all no 0 to limit;
		for (int i = 0; i < limit; i++) {
			String set = "";
			int temp = i;
			for (int j = arr.length-1 ; j >= 0; j--) {
				int remainder = temp%2;
				temp = temp/2;
				
				if(remainder==0)
					set = "_\t" + set;
				else 
					set = arr[j] +"\t"+ set;
			}
			System.out.println(set);
	}
	}

}
