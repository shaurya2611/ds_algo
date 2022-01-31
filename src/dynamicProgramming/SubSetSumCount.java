package dynamicProgramming;

public class SubSetSumCount {

	// For a given array count the number of subsets possible for the given sum
	// Here possible combinations are asked not permutation (permutation will be greater then combination)
	public static int subSetCount(int[] arr, int sum, int size) {
		int[][] dpArr = new int[size + 1][sum + 1];

		// Initialize base condition by drawing table
		for (int i = 0; i < sum + 1; i++)
			dpArr[0][i] = 0;
		for (int i = 0; i < size + 1; i++)
			dpArr[i][0] = 1;

		for (int i = 1; i < size + 1; i++) { // i-> size , j-> sum
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dpArr[i][j] = dpArr[i - 1][j - arr[i - 1]] + dpArr[i - 1][j];
				} else
					dpArr[i][j] = dpArr[i - 1][j];
			}
		}
		return dpArr[size][sum];
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int sum = 7;
		int size = arr.length;
		System.out.println(subSetCount(arr, sum, size));

	}

}
