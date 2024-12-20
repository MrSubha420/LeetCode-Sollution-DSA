class Solution {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(-1); // Dummy node to simplify result list construction
       ListNode p = dummy; // Pointer for the current position in the result list
       int carry = 0; // Initialize carry to 0

       while (l1 != null || l2 != null || carry != 0) {
           // Add values from l1 and l2 to the carry, if available
           int val1 = (l1 != null) ? l1.val : 0;
           int val2 = (l2 != null) ? l2.val : 0;

           int sum = val1 + val2 + carry; // Compute the total sum
           carry = sum / 10; // Update the carry for the next iteration
           p.next = new ListNode(sum % 10); // Create a new node for the current digit

           // Move to the next nodes in l1, l2, and the result list
           if (l1 != null) l1 = l1.next;
           if (l2 != null) l2 = l2.next;
           p = p.next;
       }

       return dummy.next; // Return the result list, skipping the dummy node
   }
}
