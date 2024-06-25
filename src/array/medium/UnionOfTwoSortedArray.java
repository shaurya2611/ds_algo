package array.medium;

import java.util.ArrayList;

public class UnionOfTwoSortedArray {

    /*
    	•	Union of two sets  A  and  B  is the set containing all elements that are in  A , in  B , or in both.
        •	Intersection of two sets  A  and  B  is the set containing only the elements that are in both  A  and  B .

        	 A = {1, 2, 3, 4}
	     	 B = {3, 4, 5, 6}

	     	 A union B        =￼ {1,2,3,4,5,6}
	     	 A intersection B =  {3,4}

      Solution : Using two pointers iterate over both arrays and compare the value and insert in new array
     */
    static ArrayList<Integer> unionOfSortedArray(int[] arr1, int[] arr2){

        ArrayList<Integer> unionArray = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lastItemInserted = Integer.MIN_VALUE;

        while (i < arr1.length && j < arr2.length) {
            int currentItem = 0;
            if(arr1[i] <= arr2[j]){
                currentItem = arr1[i];
                i++;
            }
            else {
                currentItem = arr2[j];
                j++;
            }
            if(currentItem!=lastItemInserted){
                unionArray.add(currentItem);
                lastItemInserted = currentItem;
            }
        }

        while(i < arr1.length){
            if(arr1[i] > lastItemInserted){
                unionArray.add(arr1[i]);
                lastItemInserted = arr1[i];
            }
            i++;
        }

        while(j < arr2.length){
            if( arr2[j] > lastItemInserted){
                unionArray.add(arr2[j]);
                lastItemInserted = arr2[j];
            }
            j++;
        }


        return unionArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,3,4,5,6,6,6,7,9,12,90};
        int[] arr2 = {2,2,3,4,4,4,5,99};
        unionOfSortedArray(arr1,arr2);
    }
}
