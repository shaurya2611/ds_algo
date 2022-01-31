package array;

public class SubSet {

	public static void main(String[] args) {
		// No of subarray = n(n+1)/2
		// no of subsequences = 2^n
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
