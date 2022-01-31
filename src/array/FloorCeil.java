package array;

import java.util.Scanner;

public class FloorCeil {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) 
			arr[i] = scn.nextInt();
		
		int curr = scn.nextInt();
		
		int low = 0;
		int high = arr.length-1;
		int ciel = 0;
		int floor= 0;
		
		while(low<=high) {
			int mid = (low + high)/2;
			if(arr[mid]==curr) {
				floor = arr[mid];
				ciel = arr[mid];
				break;
			}
			else if(arr[mid]>curr) {
				high = mid-1;
				ciel = arr[mid];
			}
			else {
				low = mid+1;
				floor = arr[mid];
			}
		}
		System.out.println(ciel);
		System.out.println(floor);
		
	}

}
