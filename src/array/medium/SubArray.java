package array.medium;

public class SubArray {

	// SUBARRAY - sub-array are always continuous set of elements from the array
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
