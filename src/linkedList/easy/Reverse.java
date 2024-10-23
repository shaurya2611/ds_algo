package linkedList.easy;

public class Reverse extends Node {

	
	
	/*Solution : Time - O(n) , Space - O(1)*/
	public static Node reverseList(Node head) { // 1--> 2--> 3-->4-->5
        
        //base case
        if(head==null || head.next==null)
            return head;
        
        // Hypothesis (recursion has worked on whole list except first element )
        Node rtn = reverseList(head.next); // 1        5-->4-->3-->2
        
        //Induction (add 1st element to end of new linked list)
        Node temp = head.next;
        temp.next = head;
        head.next = null;	
        return rtn;

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
