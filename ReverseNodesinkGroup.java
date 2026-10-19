class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int groups = size / k;

        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;

        while (groups-- > 0) {

            ListNode prev = null;
            ListNode groupHead = curr;

            int n = k;

            while (n-- > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            list.add(prev);

            groupHead.next = null;
        }

        for (int i = 0; i < list.size() - 1; i++) {

            ListNode tail = list.get(i);

            while (tail.next != null)
                tail = tail.next;

            tail.next = list.get(i + 1);
        }

        if (!list.isEmpty()) {
            ListNode tail = list.get(list.size() - 1);

            while (tail.next != null)
                tail = tail.next;

            tail.next = curr;

            return list.get(0);
        }

        return head;
    }
}
