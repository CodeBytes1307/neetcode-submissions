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
    public void reorderList(ListNode head) {
        
        if(head == null)
            return;
        
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode x = slow;
        x = x.next;
        
        slow.next = null;
        slow = x;

        ListNode p1 = null;
        ListNode p2 = slow;
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

        ListNode first = head;
        ListNode second = p1;   // p1 is the head of reversed second half

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}
