/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node newList = null;
        Node temp1 = null;
        HashMap<Node, Node> map = new HashMap<>();

        while (temp != null)
        {
            Node newNode = new Node(temp.val);

            if (newList == null)
                newList = newNode;
            else
                temp1.next = newNode;

            temp1 = newNode;

            map.put(temp, newNode);
            temp = temp.next;
        }

        temp1 = newList;
        temp = head;

        while (temp1 != null)
        {
            temp1.random = map.get(temp.random);
            temp1 = temp1.next;
            temp = temp.next;
        }

        return newList;
    }
}