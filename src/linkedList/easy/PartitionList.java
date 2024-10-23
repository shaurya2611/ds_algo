package linkedList.easy;

public class PartitionList {
	
	/*
	 * Given :  Given the head of a linked list and a value x, partition it such that all nodes less than x 
	 * 			come before nodes greater than or equal to x. You should preserve the original relative order 
	 * 			of the nodes in each of the two partitions.
	 * 
	 * Solution : Define two new list head pointer, such that all element less then given number join in 
	 * 			  first list head and element greater then no in second head of list.
	 * 			  Later join both list.
	 * 			  Time - O(n) and Space - O(1)
	 * */
	
	 public Node partition(Node head, int x) {
	        Node before = new Node();
	        Node beforePtr = before;
	        Node after = new Node();
	        Node afterPtr = after;
	        
	        while(head!=null){
	        	// if element less then GIVEN NO then join it with Before list
	            if(head.val < x){
	                before.next = head;
	                before = before.next;
	            }
	            // if element greater then GIVEN NO then join to After List
	            else{
	                after.next = head;
	                after = after.next;
	            }
	            head = head.next;            
	        }
	        after.next = null;
	        before.next = afterPtr.next;        
	        return beforePtr.next;
	       
	    }


}
