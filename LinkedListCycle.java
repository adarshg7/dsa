/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        HashSet<ListNode> map = new HashSet<>();
        ListNode temp = head;
        while(!map.contains(temp) || temp != null){
            if(!map.contains(temp)){
                map.add(temp);
            }else{
                return true;
            }

            if(temp.next != null)
            temp = temp.next;
            else return false;
        }
        return false;
    }
}


//Another method 

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode a = head;
       ListNode b = head;
       while(a!=null && a.next!= null){
        a= a.next.next;
        b = b.next;

        if(a==b){
            return true;
        }
       }
       return false;
    }
}
