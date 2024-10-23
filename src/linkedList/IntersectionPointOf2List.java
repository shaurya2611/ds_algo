package linkedList;

public class IntersectionPointOf2List {

	
	/*Given : the heads of two singly linked-lists headA and headB, return the node at which the 
	 * 		  two lists intersect. If the two linked lists have no intersection at all, return null.
	 * 		  listA (n - Nodes) , listB (m - Nodes)
	 * 
	 * Solution 1 : Starting from head of listA, compare it with all element of listB, similarly for 
	 * 				each element of listA till common node address not found.
	 * 				Time  - O(n*m) , Space - O(1);
	 * 
	 * Solution 2 : Make a hash map of listA, with (next) as key.
	 * 				Then traverse listB and find key in hash map
	 * 				Time - O(n + m) , Space - (n)
	 * 
	 * Solution 3 : Simultaneously find the length of both listA and ListB, take the difference of
	 * 				length, and move the larger list dummy node forward step = diff of length.
	 * 				Now both dummy pointing to both list will be at same level and now traverse and check
	 * 				the common point simultaneously.
	 * 				Time - O(n + n), Space - O(1)
	 * 
	 * Solution 4 : Time - O(n + m), Space - o(1) ,  code is smaller
	 * */
	
	
	//Solution 3
	public Node getIntersectionNode(Node headA, Node headB) {
		
		if(headA==null || headB==null)
			return null;
		
		Node dummyA = headA;
		Node dummyB = headB;
		int lenA = 0;
		int lenB = 0;
		while(dummyA!=null || dummyB!=null) {
			if(dummyA!=null) {
				lenA++;
				dummyA = dummyA.next;
			}
			if(dummyB!=null) {
				lenB++;
				dummyB = dummyB.next;
			}
		}
		
		int lenDiff = (lenA>lenB) ? (lenA-lenB) : (lenB-lenA);
	
		Node smallerList = headA;
		Node largerList = headB;
		
		if(lenA>lenB) {
			smallerList = headB;
			largerList = headA;
		}
		
		// to make both list point at same level
		for (int i = 0; i < lenDiff; i++) 
			largerList = largerList.next;
		
		Node intersect = null;
		
		while(largerList!=null && smallerList!=null) {
			if(largerList==smallerList) {
				intersect = largerList;
				return intersect;
			}
			largerList = largerList.next;
			smallerList = smallerList.next;			
		}
		return intersect;
        
    }
	
	//Solution 4
	public Node getIntersectNode(Node headA, Node headB) {
		if(headA==null || headB==null)
			return null;
		
		Node dummyA = headA;
		Node dummyB = headB;
		
		while(dummyA!=dummyB) {
			dummyA = dummyA==null ? headB : dummyA.next;
			dummyB = dummyB==null ? headA : dummyB.next;
			
		}
		
		return dummyA;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
