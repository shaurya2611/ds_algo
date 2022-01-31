package sorting;
public class MergeSortedArray {

	public static int[] mergeTwoSortedArrays(int[] a, int[] b){
	    int[] ans = new int[a.length + b.length];
	    
	    int i = 0; // pointer to array a
	    int j =0 ; // pointer for array b
	    for (int k = 0; k < ans.length; k++) {
	    	if(i<a.length && j<b.length) {
	    		if(a[i] <= b[j]) {
	    			ans[k] = a[i];
	    			i++;
	    		}else {
	    			ans[k] = b[j];
	    			j++;
	    		}
	    	}
	    	else if(j < b.length) {
	    		ans[k] = b[j];
	    		j++;
	    	}
	    	else if(i < a.length) {
	    		ans[k] = a[i];
	    		i++;
	    	}
		}
	    return ans;
	  }
	 
	 public static void print(int[] arr){
		    for(int i = 0 ; i < arr.length; i++){
		      System.out.println(arr[i]);
		    }
		  }
	 
	public static void main(String[] args) {
		int[] a = {2,5};
		int[] b = {7,9,11,15,20,25,30};
	    int[] mergedArray = mergeTwoSortedArrays(a,b);
	    System.out.println("Length 1st array : "+ a.length);
	    System.out.println("Length 2nd array : " + b.length);
	    System.out.println("Length Merged array : "+mergedArray.length);
	    print(mergedArray);

	}

}
