package linkedList;

public class RemoveGivenElement {

	/*Given : the head of a linked list and an integer val, remove all the nodes of the linked list
	 *  	  and return the new head.
	 *  
	 *  Solution : Time - O(n) , Space - O(1)*/
	
	
	public Node removeElements(Node head, int val) {
        
        if(head==null)
            return head;
        
        Node rtnhead = removeElements(head.next,val);
        
        if(head.val == val)
            return rtnhead;
        else{
            head.next = rtnhead;
            return head;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
