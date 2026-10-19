/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(l1 != null || l2 != null || carry != 0){


            int digit = 0;
            int num = carry;
            if(l1 != null){
                num += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                num += l2.val;
                l2 = l2.next;
            }
                digit = num % 10;
                carry = num / 10;
                

            temp.next = new ListNode(digit);
            temp = temp.next;
        }
        return dummy.next;
    }
}
