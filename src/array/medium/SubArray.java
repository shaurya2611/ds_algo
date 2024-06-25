package array.medium;

public class SubArray {

	/* Subarray : contiguous part of an array. This means all the elements of the subarray appear
				  in the same order as in the original array and are next to each other.
		No of subarray = n(n+1)/2
		Subarray of [1, 2, 3] = [1], [1,2], [1,2,3], [2], [2,3], [3]

	   Subset : A subset is any combination of elements from an array, regardless of their order and contiguity.
	   			This includes the empty set and the set itself.
		no of subsequences = 2^n
		Subset of [1,2,3] = [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
	*/
	public static void printAllSubArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int flag = i;
				while(flag<=j) {
					System.out.print(arr[flag]+"\t");
					flag++;
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {10,20,30,40};
		printAllSubArray(arr);


	}

}
