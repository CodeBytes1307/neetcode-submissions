class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode result = new ListNode(); // dummy node
        ListNode temp = result;

        while (temp1 != null && temp2 != null) {

            if (temp1.val < temp2.val) {
                temp.next = new ListNode(temp1.val);
                temp = temp.next;
                temp1 = temp1.next;
            }
            else if (temp2.val < temp1.val) {
                temp.next = new ListNode(temp2.val);
                temp = temp.next;
                temp2 = temp2.next;
            }
            else {
                temp.next = new ListNode(temp1.val);
                temp = temp.next;

                temp.next = new ListNode(temp2.val);
                temp = temp.next;

                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            temp.next = new ListNode(temp1.val);
            temp = temp.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            temp.next = new ListNode(temp2.val);
            temp = temp.next;
            temp2 = temp2.next;
        }

        return result.next;
    }
}