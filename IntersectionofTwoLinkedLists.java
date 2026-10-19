/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res1 = headA;
        ListNode res2 = headB;

        while(res1 != res2){
            if(res1 == null){
                res1 = headB;
            }else{
                res1 = res1.next;
            }

            if(res2 == null){
                res2 = headA;
            }else{
                res2 = res2.next;
            }
        }

        return res1;
    }
}
