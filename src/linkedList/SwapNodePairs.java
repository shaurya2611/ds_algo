package linkedList;

public class SwapNodePairs extends ListNode{
	
	
	 public static ListNode swapPairs(ListNode head) {
	        //Incase no element or only one element in linked list then return head
	        ListNode headrtn = null;
	        if(head==null||head.next==null)
	            return head;
	        // more then one element return 2 element as head(as value will be swapped will become first element)
	        else
	            headrtn = head.next;
	        
	        ListNode t1 = head;
	        ListNode t2 = null;
	        ListNode t3 = null;
	        
	        while(t1!=null && t1.next!=null)     {
	            t3 = t1.next;
	            t1.next = t3.next;
	            t3.next = t1;
	            if(t2!=null)
	                t2.next = t3;
	            t2  = t1;
	            t1 = t1.next;
	        } 
	        return headrtn;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
