package array.easy;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArray {
        /*
    	•	Union        : unique elements including both A and B set
        •	Intersection : Only common elements between two sets A and B

        	 A = {1, 2, 3, 4}
	     	 B = {3, 4, 5, 6}

	     	 A union B        =￼ {1,2,3,4,5,6}
	     	 A intersection B =  {3,4}

      Solution : Using two pointers iterate over both arrays and compare the value and insert in new array
     */

    static ArrayList<Integer>  intersectionOfSortedArray(int[] arr1, int[] arr2){
        ArrayList<Integer> intersectionArray = new ArrayList<>();
        int pointerArr1 = 0;
        int pointerArr2 = 0;
        int lastElementAdded =Integer.MIN_VALUE;

        while(pointerArr1 < arr1.length && pointerArr2 < arr2.length){

            if (arr1[pointerArr1] > arr2[pointerArr2])
                pointerArr2++;
            else if (arr1[pointerArr1] < arr2[pointerArr2])
                pointerArr1++;
            else {
                if (lastElementAdded!=arr1[pointerArr1]) {
                    intersectionArray.add(arr1[pointerArr1]);
                    lastElementAdded = arr1[pointerArr1];
                }

                pointerArr1++;
                pointerArr2++;
            }
        }

        return intersectionArray;

    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6,7};
        int[] arr2 = {3, 4, 5, 6};
        intersectionOfSortedArray(arr1,arr2);
    }
}
