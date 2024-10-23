package linkedList;

public class RemoveDuplicateSortedList {
	
	/*
	 * Given : Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
	 *         Return the linked list sorted as well.
	 *         Input: head = [1,1,2,3,3]
			   Output: [1,2,3]
	 * 
	 * Solution : Time - O(n), Space - (1)
	 * */	
	public Node deleteDuplicates(Node head) {
        Node t1 = head;
        while(t1!=null && t1.next!=null){
            if(t1.val==t1.next.val){
                Node t2 = t1;
                while(t2.next!=null && t2.val==t2.next.val){
                   t2 = t2.next; 
                }
                t1.next = t2.next;
            }
            t1 = t1.next;
        }
       return head; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
