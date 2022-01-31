package linkedList;



public class RemoveNthElementFromEnd extends ListNode{
	
	/*
	 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
	 * 
	 * Solution 1. O(2n) - traverse whole list once find size then remove nth element
	 * 
	 * Solution 2. O(n) - Moving fast pointer initially 'n' steps, after that move both simultaneously till
	 * 					  fast reaches end of list. Slow will be pointing to element just bore to be deleted.
	 * */
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
			
			// Creating one new node before head
		    ListNode extraNode = new ListNode();
	        extraNode.next = head;
	        ListNode fast = extraNode;
	        ListNode slow = extraNode;
	        
	        // Moving fast pointer move "n" steps from starting
			for (int i = 0; i < n; i++)
				fast = fast.next;
	        
			// Now move both fast and slow simultaneously till fast reached last of list
			// Slow after traversal --> point to element just before to be deleted
			while(fast.next!=null) {
				fast = fast.next;
				slow = slow.next;
			}
	        slow.next = slow.next.next;
	        
			return extraNode.next;
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
