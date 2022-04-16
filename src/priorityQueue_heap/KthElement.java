package priorityQueue_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthElement {
/* Solution-1:  Sort array and find kth index element
                time - O(nlogn) for merge sort (fastest)

   Solution-2: If asked the smallest form max heap, if asked largest form min heap,
               Iterate over the array push current element into the heap and if any time
               heap size greater than 'k' pop element from top. After array iteration ttop of heap will give ans.
               time - O(nlogk) logK as for any time size heap is always k. And n for array iteration
* */
    public static int smallestKElement(int[] arr, int k){
        // smallest element asked hence max heap formed
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr){ // n
            pq.add(x);// logk
            if(pq.size()>k) pq.remove();
        }
        return pq.peek();
    }

    public static void main(String[] args){
        int[] arr = {5,7,2,9,3,1,-1};
        System.out.println(smallestKElement(arr,4));
    }

}
