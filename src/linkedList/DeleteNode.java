 package linkedList;

public class DeleteNode {

	
	/*Given : delete a node in a singly-linked list. Access to the head of the list not given, 
	 * 		  instead you will be given access to the node to be deleted directly.
	 * 
	 * Solution : On the given node copy the next node value and in next node pointer value
	 * 			  Time and Space : O(1)
	 * 
	 * */
	
	public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
