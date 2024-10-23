package linkedList;

public class PalindromeCheck extends Reverse {
	/*Given : The head of a singly linked list, return true if it is a palindrome.
	 *Solution 1: Traverse and store whole linked list in array.
	 *			  Traverse whole Array and check palindrome
	 *			  Time- O(n + n) , Space - O(n); -- space req. for array storage 
	 *
	 *Solution 2: Find the mid of list, Reverse the linked list from (mid+1 to tail)
	 *			  Start comparing element from 1 and mid+1, if all equal then palindrome else not 
	 *			  Time - O{(n/2) + (n/2) + (n/2)} , Space - O(1)  
	 * */
	public boolean isPalindrome(Node head) {
        //mid of linked list (after loop ends slow points to mid)
        Node slow = head;
        Node fast = head;
        
        // (n/2 complexity in findind mid)
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // (n/2 complexity of half list reversal)
        slow.next = reverseList(slow.next);  
        slow = slow.next;
        
        // (n/2 complexity in comparing elements till mid)
        while(slow!=null){
            if(slow.val!=head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
