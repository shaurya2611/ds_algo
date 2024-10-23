package linkedList.easy;

public class RemoveDuplicateSortedList2 {

	/*
	 * Given : Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving
	 * 		   only distinct numbers from the original list. Return the linked list sorted as well.
	 * 			Input: head = [1,2,3,3,4,4,5]
				Output: [1,2,5]
	 * */
	public Node deleteDuplicates(Node head) {
		Node rtnHead = new Node();
		rtnHead.next = head;
		Node t = rtnHead;
		
        Node t1 = t.next;
        while(t1!=null && t1.next!=null){
            if(t1.val==t1.next.val){
                Node t2 = t1;
                while(t2.next!=null && t2.val==t2.next.val){
                   t2 = t2.next; 
                }
                t1 = t2.next; 
            }
            else {
            	t.next = t1;
            	t = t.next;
            	t1 = t1.next; 
        }
        if(t1!=null) {
        	t.next = t1;
        	t = t.next;
        }
        t.next=null;
    }
        return rtnHead.next;
}
}
