package linkedList;

public class SwapNodePairs extends Node {
	
	
	 public static Node swapPairs(Node head) {
	        //Incase no element or only one element in linked list then return head
	        Node headrtn = null;
	        if(head==null||head.next==null)
	            return head;
	        // more then one element return 2 element as head(as value will be swapped will become first element)
	        else
	            headrtn = head.next;
	        
	        Node t1 = head;
	        Node t2 = null;
	        Node t3 = null;
	        
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
