package array;

public class FirstLastOcc {

	public static void main(String[] args) {
		
		int[] arr = {1,2,2,2,3,6,7,8,8,8,8,10};
		int number = 2; 
		
		int high = arr.length -1;
        int low = 0;
        int firstOcc = -1;
        
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] == number){
            	firstOcc = mid;
                high = mid-1;
            }
            else if(arr[mid] > number)
                high = mid-1;
            else
                low = mid+1;
        }
        System.out.println(firstOcc);
        
        int lastOcc = firstOcc;
        for (int i = firstOcc+1; i < arr.length; i++) {
			if(arr[i]==number) {
				lastOcc = i;
			}
			else
				break;
		}
        
        System.out.println(lastOcc);
	}

}
