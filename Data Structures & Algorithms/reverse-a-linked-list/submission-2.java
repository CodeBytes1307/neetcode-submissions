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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = p2;

        if(p2 != null)
            p3 = p2.next;

        while(p2 != null)
        {
            p2.next = p1;
            p1 = p2;
            p2 = p3;

            if(p3 != null)
                p3 = p3.next;
        }

        return p1;
    }
}
