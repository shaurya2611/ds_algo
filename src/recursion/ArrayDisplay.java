package recursion;

public class ArrayDisplay {

	public static void displayArray(int[] arr, int idx) {
		//base case
		if(idx==arr.length)
				return;
		//Hypothesis
		displayArray(arr, idx+1);
		//Induction 
		System.out.println(arr[idx]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,50};
		displayArray(arr,0);
	}

}

