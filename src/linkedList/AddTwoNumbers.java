package linkedList;

public class AddTwoNumbers extends ListNode{
	
	
	/* Ques- Given two no in form in reverse order in of linked list*
	 * Solution- Trverse the linked lists and start adding from head and maintain carry if greater than 9 */
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode ans = new ListNode();
         ListNode temp = ans;
         int carry = 0;
         
         // loop run till both the linked list are traversed
         while(l1!=null || l2!=null){
             int sum = 0;
             if(l1!=null && l2!=null){
                 sum = l1.val + l2.val + carry;
                 l1 = l1.next;
                 l2 = l2.next;
             }
             else if(l1!=null){
                 sum = l1.val  + carry;
                 l1 = l1.next;
             }
             else{
                 sum = l2.val + carry;
                 l2 = l2.next;
             }
             
           if(sum>9){
               ListNode node = new ListNode(sum-10 , null);
                carry = 1;
               temp.next = node;             
           }  
           else{
                ListNode node = new ListNode(sum, null);
               temp.next = node;
               carry = 0;
           } 
           temp = temp.next;  
         }
         if(carry!=0){
              ListNode node = new ListNode(1, null);
              temp.next = node;}
         return ans.next;
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
