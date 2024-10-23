package linkedList.easy;

public class OddEvenList {
	
	/*
	 * Given :  Given the head of a singly linked list, group all the nodes with odd indices together followed 
	 * 			by the nodes with even indices, and return the reordered list.
	 * 			Input : [2,1,3,5,6,4,7]
				Output: [2,3,6,7,1,5,4]
	 * 
	 * Solution : Form to new node and link alternative odd and even nodes to both simultaneously.
	 * 			  Time - O(n) , Space - O(1) 
	 * */
	public static Node oddEven(Node head) {
		
		if(head==null || head.next==null || head.next.next==null)
			return head;
		
		Node oddNodes = new Node();
		Node evenNodes = new Node();
		Node odd = oddNodes;
		Node even = evenNodes;
		
		while(head.next!=null) {
			oddNodes.next = head;
			odd = odd.next;
			evenNodes.next = head.next;
			even = even.next;
			head = head.next.next;
		}
		
		return head;
	}
}
