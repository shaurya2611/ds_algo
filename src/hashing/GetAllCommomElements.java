package hashing;

import java.util.HashMap;

public class GetAllCommomElements {

    /* From given two array get all the common elements including repetitions */

    public static  void main(String[] args){
        int[] arr1 = {1,1,2,2,2,3,5};
        int[] arr2 = {1,1,1,2,2,4,5};
        //ans should be : 1,1,2,2,5

        HashMap<Integer,Integer> elementCount = new HashMap<>();

        //loop on any array to keep count of all the characters and their occurance
        for(int i:arr1){
            if (elementCount.containsKey(i))
                elementCount.put(i,elementCount.get(i)+1);
            else
                elementCount.put(i,1);
        }
        // for each element of second array find it in hash map and if that element found in hasf map decrease count by one
        for (int i:arr2){
            if (elementCount.containsKey(i)){
                if (elementCount.get(i)>0){
                    System.out.print(i+", ");
                    elementCount.put(i,elementCount.get(i)-1);
                }
            }
        }

    }
}
