package linkedList;

/*
 * Given :  You are given the head of a singly linked-list. The list can be represented as:
		    L0 → L1 → … → Ln - 1 → Ln
			Reorder the list to be on the following form: 
			L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
			
   Solution : Traverse at Mid Point --> Reverse second half -->Merge both list one on element
			  Time Complexity: O (n/2 + n/2 + n/2) = O(n) , Space Complexity: O (1)
 * */

public class ReorderList {
	
	public void reorderList(ListNode head) {
        if(head==null|| head.next==null ||head.next.next==null)
            return;
        
        // Mid of linked list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Second half list reversal
        ListNode reversedList = reverseList(slow.next);
        slow.next = null;
        
        
        // Both list merge
        while (reversedList!=null) {
            ListNode firstNext = head.next;
            ListNode secondNext = reversedList.next;
            head.next = reversedList;
            reversedList.next=firstNext;
            reversedList = secondNext;
            head = firstNext;
        }
        
         
    }
    
     public ListNode reverseList(ListNode head) { // 1--> 2--> 3-->4-->5
        
        //base case
        if(head==null || head.next==null)
            return head;
        
        // Hypothesis (recusrsion has worked on whole list except first element )
        ListNode rtn = reverseList(head.next); // 1        5-->4-->3-->2
        
        //Induction (add 1st element to end of new linked list)
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return rtn;

    }


}
