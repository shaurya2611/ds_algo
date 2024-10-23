package linkedList;

public class RotateList {
	
	/*
	 * Given the head of a linked list, rotate the list to the right by k places.
	 * n - no of nodes in list
	 * k - no of rotation - 0 to 2^10, any positive no
	 * 
	 * Solution 1. O(k*n) , n = no of nodes in linked list.
	 * 			   Traverse to tail of list and put last element at start position. Repeat same step 'k' times
	 * 			   At last results in Rotated List
	 * 
	 * Solution 2. O(n + n) = o(N)	
	 * 			   Find length, simplify 'k' if greater then n, as after n rotation original list is obtained
	 * 			   and 'k' can be any +ive value.
	 * 			   MAKE LIST CIRCULAR by joining head and tail. After that move tail = no of traversal 	
	 *  
	 * */
	 public static Node rotateRight(Node head, int k) {
	        
	        if(head==null || head.next==null || k==0)
	            return head;
	        	         
	        // Finding size and tail of list
	        int size = 1;
	        Node tail = head;
	        while(tail.next!=null){
	            size++;
	            tail = tail.next;
	        }
	        
	        // Converting list into circular linked list
	        tail.next = head; 
	                        
	        // No of rotations required(no of rotation = size list , list remain same)
	        int noRotation = k%size; // % --> collect the remainder
	        if(noRotation==0)
	            return head;
	        int noTraversal = size - noRotation;
	        
	        // Moving tail = no of traversal req, and marking head and null of list
	        while(noTraversal > 0){
	            tail = tail.next;
	            noTraversal--;
	        }  
	        head = tail.next;
	        tail.next = null;
	        
	        return head;
	    }
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
