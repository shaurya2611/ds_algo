package linkedList;

public class LinkedListCycle {
	
	/*
	 * Given :  Given head, the head of a linked list, determine if the linked list has a cycle in it.
				There is a cycle in a linked list if there is some node in the list that can be reached 
				again by continuously following the next pointer. 
				If there is CYCLE LIST, there will be no null 
				
	   Solution 1: Using HASH MAP keep track of all the node including value and next pointer. If repeated 
	   			   node found return true else false
	   			   Time O(n) , Space - O(n)
	   			   
	   Solution 2: Using FAST and SLOW concept for finding mid of linked list i.e. moving SLOW by one step and
	   			   fast by 2 step till both slow and fast point to same node or fast point to null
	   			   * If list is circular both slow and fast will be equal at some point of time
	   			   * If fast = null; List is not circular
	   			    Time O(n) , Space - O(1)
	 * */
	 public boolean hasCycle(Node head) {
		 
		 if(head==null || head.next==null)
		 	return false;
		 
		 Node slow = head;
		 Node fast = head;
		 
		 while(fast.next!=null && fast.next.next!=null) { // (fast!=null && fast.next!=null) - also work
			 slow = slow.next;
			 fast = fast.next.next;
			 // If list circular both fast and slow will meet at one point
			 if(fast==slow)
				 return true;			 
		 }
		return false;
		   
	    }
}
