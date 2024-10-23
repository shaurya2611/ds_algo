package linkedList.easy;

public class LinkedListCycle2 {
	
	/*
	 * Given :  Given head, the head of a linked list, determine if the linked list has a cycle in it and return the
	 * 			node from circular list started. There is a cycle in a linked list if there is some node in the list
	 * 		    that can be reached again by continuously following the next pointer. 
				If there is CYCLE LIST, there will be no null 
				
	   Solution 1: Using HASH MAP keep track of all the node including value and next pointer. If repeated 
	   			   node found return true else false
	   			   Time O(n) , Space - O(n)
	   			   
	   Solution 2: Using FAST and SLOW concept for finding mid of linked list i.e. moving SLOW by one step and
	   			   fast by 2 step till both slow and fast point to same node or fast point to null
	   			   * If list is circular both slow and fast will be equal at some point of time
	   			   * If fast = null; List is not circular
	   			   * If slow and fast pointers meet at a node bring one of them to the beginning
                     Now, they are at a same distance to the node where the cycle begins we just need to move 
                     them 1 step to the right until they meet each other
	   			     Time O(n) , Space - O(1)
	 * */
	
	 public Node detectCycle(Node head) {
		 if(head==null || head.next==null)
			 	return null;
			 
			 Node slow = head;
			 Node fast = head;
			 int flag = 0;
			 
			 while(fast.next!=null && fast.next.next!=null) { 
				 slow = slow.next;
				 fast = fast.next.next;
				 // If list circular both fast and slow will meet at one point
				 if(fast==slow) {
					 flag = 1;
					 break;		
					 }	 
			 }
			 if(flag==0)
				 return null;
			 
			 fast = head;
			 
		        while (slow != fast) {
		            slow = slow.next;
		            fast = fast.next;
		        }
		        return slow;
	    }
}
