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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        ListNode temp = head;
        int delete = 0;
        while(temp != null)
        {
            delete++;
            temp = temp.next;
        }

        temp = head;
        delete = delete - n;
        if(delete == 0)
            return head.next;

        for(int i = 0; i < delete -1; i++)
        {
            temp = temp.next;
        }

        if(temp != null && temp.next != null)
        {
            temp.next = temp.next.next;
        }
        else if(temp != null)
        {
            temp.next = null;
        }

        return head;
    }
}
