package array;

import java.util.Scanner;

public class Introduction {

	public void barChart(int no) {
		System.out.println("Enter the elements : ");
		Scanner scn = new Scanner(System.in);
	    int n = no;
	    int[] arr = new int[n];
	
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = scn.nextInt();
	    }
	    
	    int maxStory = arr[0];
	    for (int i = 0; i < arr.length; i++) {
			if(arr[i]>maxStory)
				maxStory = arr[i];
		}
	    
	    for (int i = 0; i < maxStory; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i > (arr.length-arr[j]))
					System.out.print(" * ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
    
	}
	

	public void sumTwoArray(int a,int b) {
		System.out.println("Enter the elements of 1st array: ");
		Scanner scn = new Scanner(System.in);
		
	    int[] arrFirst = new int[a];
	    for (int i = 0; i < arrFirst.length; i++)
	    	arrFirst[i] = scn.nextInt();
	    
	    int[] arrSecond = new int[b];
	    for (int i = 0; i < arrFirst.length; i++)
	    	arrSecond[i] = scn.nextInt();
	    
	    
	    
	    
	    
	    
	    
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Introduction i = new Introduction();
//		i.barChart(4);
		i.barChart(5);

	}

}
