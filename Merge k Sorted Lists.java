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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode node : lists){
            if(node != null) que.add(node);
        }

        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while(!que.isEmpty()){
            ListNode curr = que.poll();
            res.next = curr;
            res = res.next;

            if(curr.next != null){
                que.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
//or

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return dnc(lists, 0, lists.length-1);
    }

    public ListNode dnc(ListNode[] lists, int left , int right){
        if(left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = dnc(lists, left, mid);
        ListNode l2 = dnc(lists, mid + 1, right);
        return mergeTwoLists(l1,l2); 
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if ( l1 == null) return l2;
        if( l2 == null ) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;  
        }
    }
}
